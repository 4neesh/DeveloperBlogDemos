package person

import (
	"database/sql"
	"demo/web-service-2/database"
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"
	"strconv"
	"strings"
)

type Person struct {
	Id   int
	Name string
	Age  int
}

func getPeople() ([]Person, error) {

	results, err := database.DbConn.Query(`SELECT Id, Name, Age FROM people`)
	if err != nil {
		log.Fatal(err)
	}
	defer results.Close()
	personList := make([]Person, 0)
	for results.Next() {
		var person Person
		results.Scan(&person.Id, &person.Name, &person.Age)
		personList = append(personList, person)

	}
	return personList, nil

}

func getPerson(personId int) (*Person, error) {

	row := database.DbConn.QueryRow(`SELECT Id, Name, Age FROM people where Id = ?`, personId)
	person := &Person{}

	err := row.Scan(&person.Id, &person.Name, &person.Age)
	if err == sql.ErrNoRows {
		return nil, nil
	} else if err != nil {
		return nil, err
	}

	return person, nil
}

func updatePerson(person Person) error {
	_, err := database.DbConn.Exec(`UPDATE people SET Name = ?, Age = ? where Id = ?`,
		person.Name, person.Age, person.Id)
	if err != nil {
		return err
	}
	return nil
}

func deletePerson(personId int) error {
	_, err := database.DbConn.Exec(`DELETE FROM people where Id = ?`,
		personId)
	if err != nil {
		return err
	}
	return nil
}

func insertPerson(person Person) (int, error) {
	result, err := database.DbConn.Exec(`INSERT INTO people (Name, Age) 
	VALUES (?, ?);`, person.Name, person.Age)

	if err != nil {
		return 0, err
	}
	insertId, err := result.LastInsertId()
	if err != nil {
		return 0, nil
	}
	return int(insertId), nil
}

func PersonHandler(w http.ResponseWriter, r *http.Request) {

	switch r.Method {
	case http.MethodGet:
		personList, err := getPeople()
		if err != nil {
			log.Fatal(err)
		}
		personJson, err := json.Marshal(personList)
		if err != nil {
			w.WriteHeader(http.StatusInternalServerError)
			return
		}

		w.Header().Set("Content-Type", "application/json")
		w.Write(personJson)
	case http.MethodPut:
		var updatedPerson Person
		bodyBytes, err := ioutil.ReadAll(r.Body)
		if err != nil {
			w.WriteHeader(http.StatusBadRequest)
			return
		}
		err = json.Unmarshal(bodyBytes, &updatedPerson)
		if err != nil {
			w.WriteHeader(http.StatusBadRequest)
			return
		}

		err = updatePerson(updatedPerson)

		if err != nil {
			w.WriteHeader(http.StatusBadRequest)
			return
		}

		w.WriteHeader(http.StatusOK)
		return
	case http.MethodPost:
		var newPerson Person

		personDetails, err := ioutil.ReadAll(r.Body)
		if err != nil {
			w.WriteHeader(http.StatusBadRequest)
			return
		}
		err = json.Unmarshal(personDetails, &newPerson)
		if newPerson.Id != 0 {
			w.WriteHeader((http.StatusBadRequest))
			return
		}

		result, err := insertPerson(newPerson)
		if err != nil {
			log.Fatal(err)
		}
		if result == 0 {
			log.Fatal(err)
		}

		w.WriteHeader(http.StatusCreated)
		return
	}

}

func SinglePersonHandler(w http.ResponseWriter, r *http.Request) {

	urlPathSegments := strings.Split(r.URL.Path, "people/")
	personId, err := strconv.Atoi(urlPathSegments[len(urlPathSegments)-1])
	if err != nil {
		w.WriteHeader(http.StatusNotFound)
		return
	}
	person, err := getPerson(personId)
	if err != nil {
		w.WriteHeader(http.StatusNotFound)
		return
	}
	if person == nil {
		w.WriteHeader(http.StatusNotFound)
		return
	}

	switch r.Method {
	case http.MethodGet:
		personJson, err := json.Marshal(person)
		if err != nil {
			w.WriteHeader(http.StatusInternalServerError)
			return
		}
		w.Header().Set("Content-Type", "application/json")
		w.Write(personJson)
	case http.MethodDelete:
		err := deletePerson(personId)
		if err != nil {
			w.WriteHeader(http.StatusInternalServerError)
			return
		}
		w.WriteHeader(http.StatusOK)
		return
	default:
		w.WriteHeader(http.StatusMethodNotAllowed)
	}
}

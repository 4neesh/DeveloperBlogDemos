package main

import (
	"demo/web-service-2/database"
	"demo/web-service-2/person"
	"net/http"

	_ "github.com/go-sql-driver/mysql"
)

func main() {

	database.SetupDatabase()
	personHandler := http.HandlerFunc(person.PersonHandler)
	singlePersonHandler := http.HandlerFunc(person.SinglePersonHandler)

	http.Handle("/people", personHandler)
	http.Handle("/people/", singlePersonHandler)
	http.ListenAndServe(":5000", nil)

}

func middlewareHandler(handler http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {

		handler.ServeHTTP(w, r)
	})
}

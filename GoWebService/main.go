package main

import (
	"encoding/json"
	"log"
	"net/http"
)

func main() {

	foo := func(w http.ResponseWriter, r *http.Request) {

		names := r.URL.Query()["name"]
		var name string
		if len(names) == 1 {
			name = names[0]
		}

		// w.Write([]byte("Hello World : " + name))
		m := map[string]string{"name": name}
		enc := json.NewEncoder(w)
		enc.Encode(m)
	}
	http.HandleFunc("/", foo)

	err := http.ListenAndServe(":3000", nil)
	if err != nil {
		log.Fatal(err)
	}
}

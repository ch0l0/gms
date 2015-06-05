class UrlMappings {

	static mappings = {
        name homePage:"/"(controller:"home", parseRequest: true){
            action = [GET: "index"]
        }
        name loginPage: "/login/"(controller: "login", parseRequest: true){
            action = [GET: "showLogin", POST: "auth"]
        }

        "/logout/"(controller: "login", parseRequest: true, action:"logout")
	}
}

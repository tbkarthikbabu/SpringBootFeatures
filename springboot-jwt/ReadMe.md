JWT TOken

1. Generate JWT Token - using the authenticate API
	
	curl --location --request POST 'http://localhost:8080/authenticate' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "username":"admin",
	    "password":"password"
	}'
	
2. Call the getHello method using the Bearer Token, it will call the api thru JwtAuthenticationEntryPoint

	it will validate the token which is provided by the generateJwtToken Api and will validate the authentication server.

	curl --location --request GET 'http://localhost:8080/hello' \
	--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNDcwMDQ3NSwiaWF0IjoxNjE0NjgyNDc1fQ.EftI25kHChtiKoXMiCkGAAjiqNuSx0gHykO8DNe9QTXI1RSMGN3GHLb0FxFZszBmSexUaIx6aEPgzi5vVvoMHA'
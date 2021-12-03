## To add a user 
- Start the application
- Add a user via postman
- POST to localhost:8080/api/v1/registration
  - body: {
    "firstName": "Arno",
    "lastName": "Vandijck",
    "email": "hello@arno.com",
    "password": "password"
    }

## To confirm the email
- Open your terminal
- Start mailing server by typing 'maildev' (npm install -g maildev)
- Go to http://0.0.0.0:1080
- Open the mail and click on activate
- You now should see a new page saying 'confirmed'
  - If you would click the activation link again you should see an error msg saying: 'email already confirmed'

## To test the login
- Start the application
- Go to: http://localhost:8080/login
- Login with the correct credentials 
  - username: hello@arno.com
  - password: password

## To logout
- Go to: http://localhost:8080/login?logout

## To check if everything is working in the database
- Open your terminal
- type: 
  - psql postgres
  - \c registration
  - \x 
  - SELECT * FROM app_user;
  - SELECT * FROM confirmation_token;


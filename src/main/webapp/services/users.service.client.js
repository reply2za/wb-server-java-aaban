const url = 'https://wbdv-generic-server.herokuapp.com/api/aaban-z/users';

// actions for the server
const userService = {
  findAllUsers: () =>
      // fetch returns the promise, then calls the .then function
      fetch(url)
      .then(response => response.json()),
  deleteUser: (userId) =>
      // fetch is a 'get' by default, change it to 'DELETE' using JSON
      fetch(url + "/" + userId, {
        method: "DELETE"
      })
      .then(response => response.json()),
  createUser: (user) =>
      fetch(url, {
        method: "POST",
        // stringify - string representation of the JSON object
        body: JSON.stringify(user),
        headers: {
        // tells the server that this is a JSON
          "content-type": "application/json"
        }
        // server returns the object that was stored into the database
      })
      .then(response => response.json()),
  updateUser: (userId, updatedUser) =>
      fetch(`${url}/${userId}`, {
        method: "PUT", // update a record
        // stringify the updated user and inform the server that it's a JSON
        body: JSON.stringify(updatedUser),
        headers: {
          "content-type": "application/json"
        }
      })
      .then(response => response.json())
}
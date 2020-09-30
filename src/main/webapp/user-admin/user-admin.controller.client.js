// source code is embedded inside a function - variables are now local variables
// is a lambda function
(function () {
  let users = [
    {
      username: "alice",
      password: "abcPass,",
      fName: "Alice",
      lName: "Wonderland",
      role: "STUDENT"
    },
    {
      username: "bob",
      password: "abcPass",
      fName: "Bob",
      lName: "Marley",
      role: "STUDENT"
    },
    {
      username: "charlie",
      password: "abcPass",
      fName: "Charlie",
      lName: "Garcia",
      role: "FACULTY"
    }
  ]

  const onclickEventHandler = () => {
    alert("Press 'home' to go to the landing page.")
  }

  const deleteUser = (event) => {
    const deleteBtn = event.currentTarget
    const $deleteBtn = $(deleteBtn)
    // const parent = $deleteBtn.parent().parent().parent()
    const parent = $deleteBtn.parents("tr")
    console.log(parent)
    parent.remove()
    // alert("delete user")
  }

  const deleteUser2 = (index) => {
    const user = users[index]
    const userId = user._id
    userService.deleteUser(userId)
    .then(status => {
      // after confirmation, do these actions
      console.log(status)
      users.splice(index, 1)
      renderUsers(users)
    })
  }

  // remember who the user is
  let selectedUserIndex = -1
  const selectUser = (index) => {
    selectedUserIndex = index
    // grab the field that is the username
    $("#usernameFld").val(users[index].username)
    $("#firstNameFld").val(users[index].first)
    $("#lastNameFld").val(users[index].last)
  }

  let $template
  let tbody

  function renderUsers(users) {
    tbody.empty()
    for(let i=0; i<users.length; i++) {
      const user = users[i]
      const username = user.username
      const pw = user.password
      const fName = user.first
      const lName = user.last
      const ro = user.role

      const $clone = $template.clone()

      //$clone.removeClass("wbdv-hidden")

      const $username = $clone.find(".wbdv-username")
      $username.html(username)

      const $password = $clone.find(".wbdv-password")
      $password.html(pw)

      const $firstName = $clone.find(".wbdv-first-name")
      $firstName.html(fName)

      const $lastName = $clone.find(".wbdv-last-name")
      $lastName.html(lName)

      const $role = $clone.find(".wbdv-role")
      $role.html(ro)

      const $removeBtn = $clone.find(".wbdv-remove")
      $removeBtn.click(() => deleteUser2(i))
      $clone
      .find(".wbdv-select")
      // on a click event, selects the user, pass the index
      .click(() => selectUser(i))

      tbody.append($clone)
    }
  }

  const createUser = () => {
    // retrieve the value of the field, put it in a global constant
    const username = $("#usernameFld").val()
    console.log(username)
    const password = $("#passwordFld").val()
    const first = $("#firstNameFld").val()
    const last = $("#lastNameFld").val()
    const role = $("div.container select").val()

    const newUser = {
      username,
      first,
      password,
      last,
      role
    }

    userService.createUser(newUser)
    // get back the actual inserted user from the server
    .then(actualInsertedUser => {
      // push into the local array
      users.push(actualInsertedUser)
      // render on the website
      renderUsers(users)
    })
  }

  const updateUser = () => {
    const updatedFields = {
      // grab the username field and read the value
      username: $("#usernameFld").val(),
      password: $("#passwordFld").val(),
      first: $("#firstNameFld").val(),
      last: $("#lastNameFld").val(),
      role: $("#roleFId").val()
    }
    // process of telling the server about the updates to be made
    const userId = users[selectedUserIndex]._id
    userService.updateUser(userId, updatedFields)
    .then(() => {
      users[selectedUserIndex] = updatedFields
      renderUsers(users)
    })
  }

  function init() {
    const heading1 = jQuery("h1")
    //inital styling can be put here
    heading1
    .css("backgroundColor", "#ffa6a6")
    .html("User Administration")
    .append(" - For Administrators")
    .click(onclickEventHandler)

    $template = jQuery(".wbdv-template")
    tbody = $("tbody.wbdv-tbody")
    $(".wbdv-create").click(createUser)
    $(".wbdv-update").click(updateUser)

    // fulfilling the promise here
    userService.findAllUsers()
    .then(_users => {
      console.log(_users)
      users = _users
      renderUsers(users)
    })
  }

  jQuery(init)

})() //informs that it is a function
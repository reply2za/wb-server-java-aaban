// source code is embedded inside a function - variables are now local variables
// is a lambda function
(function () {
  let users = [
    {
      username: "alice",
      fName: "Alice",
      lName: "Wonderland",
      role: "STUDENT"
    },
    {
      username: "bob",
      fName: "Bob",
      lName: "Marley",
      role: "STUDENT"
    },
    {
      username: "charlie",
      fName: "Charlie",
      lName: "Garcia",
      role: "FACULTY"
    }
  ]

  const onclickEventHandler = () => {
    alert("heading clicked")
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

  // remeber who the user is
  let selectedUserIndex = -1
  const selectUser = (index) => {
    selectedUserIndex = index
    // grab the field that is the username
    $("#usernameFld").val(users[index].username)
  }

  let $template
  let tbody

  function renderUsers(users) {
    tbody.empty()
    for(let i=0; i<users.length; i++) {
      const user = users[i]
      const username = user.username
      const fName = user.first
      const lName = user.last
      const role = user.role

      const $clone = $template.clone()

      $clone.removeClass("wbdv-hidden")

      const $username = $clone.find(".wbdv-username")
      $username.html(username)
      const $firstName = $clone.find(".wbdv-first-name")
      $firstName.html(fName)
      const $lastName = $clone.find(".wbdv-last-name")
      $lastName.html(lName)
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
    const first = $("#firstNameFld").val()
    const last = $("#lastNameFld").val()

    const newUser = {
      username,
      first,
      last
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
      first: $("#firstNameFld").val()
    }
    // process of telling the server about the updates to be made
    const userId = users[selectedUserIndex]._id
    userService.updateUser(userId, updatedFields)
    .then(status => {
      users[selectedUserIndex] = updatedFields
      renderUsers(users)
    })
  }

  function init() {
    const heading1 = jQuery("h1")
    // heading1.remove()
    heading1
    .css("backgroundColor", "blue")
    .html("User Administration")
    .append(" - for Administrators Only")
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
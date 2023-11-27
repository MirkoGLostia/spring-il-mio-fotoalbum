const apiUrl = 'http://localhost:8080/api/v1/message/create';
var artistId = sessionStorage.getItem("artistId");
const rootDetail = document.getElementById('root-detail');


// send message

document.getElementById('newMessageForm').addEventListener('submit', function (event) {
    event.preventDefault();

    try {
        var formData = new FormData(event.target);


        fetch('http://localhost:8080/api/v1/message/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                email: formData.get('email'),
                message: formData.get('message'),
                userMessage: {
                    id: 1
                }
            }),
        })
            .then(response => {
                if (response.error) {
                    throw new Error('Failed to create new pizza');
                }
                return window.location.replace("http://127.0.0.1:5500/front-end/photo-list.html");

            })
    } catch (error) {
        console.error('unexpected error', error);
    }

});
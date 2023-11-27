/*********
 *CONSTANTS*
 **********/

const apiUrl = 'http://localhost:8080/api/v1/photo';
let urlModified = apiUrl;
const rootList = document.getElementById('root-list');

/************
 * FUNCTIONS*
 ************/

// photo list

const renderPhoto = (element) => {
    return `<div onclick="setUserId(${element.id})">
    <div class="intra-container">

    <div class="left-card">
        <h2>
            ${element.title}
        </h2>

        <img src="${element.image}"
            alt="image">
    </div>

</div>`;
}

const renderPhotoList = (photos) => {
    let photosRender;

    if (photos.length > 0) {

        photosRender = '<div>';

        photos.forEach((element) => {
            photosRender += '<div class="card-container">';
            photosRender += renderPhoto(element);
            photosRender += '</div></div>';
        });

        photosRender += '</div>';

    } else {
        photosRender = '<div><h3>no photos available</h3></div>';
    }

    rootList.innerHTML = photosRender;
};

const getPhotoList = async () => {

    try {
        const response = await axios.get(urlModified);
        renderPhotoList(response.data);
    } catch (error) {
        console.log(error);
    }
};

getPhotoList();




// search photo

function searchPhoto() {
    const searchWord = document.getElementById('searchPhoto').value;

    urlModified = apiUrl

    if (searchWord != '') {
        urlModified += "?search=";
        urlModified += searchWord;
    }

    getPhotoList();
};


// detail photo

function setUserId(id) {

    var artistId = id;

    sessionStorage.setItem("artistId", artistId);


    window.location.href = "http://127.0.0.1:5500/front-end/detail-photo.html";

}

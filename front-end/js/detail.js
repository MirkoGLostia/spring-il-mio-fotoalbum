
const apiUrl = 'http://localhost:8080/api/v1/photo/';
var artistId = sessionStorage.getItem("artistId");
const rootDetail = document.getElementById('root-detail');

const renderCategory = (categories) => {

    let renderCategory;

    if (categories.length === 0) {
        renderCategory = 'No categories';
    } else {
        renderCategory = '<ul class="list">';
        categories.forEach((cat) => {
            renderCategory += `<li>${cat.name}</li>`;
        });
        renderCategory += '</ul>';
    }
    return renderCategory;

}

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

    <div class="right-card">
        <p> ${element.description}</p>
        <p>${renderCategory(element.categories)}</p>
        <span>By: ${element.userPhoto.nickname}</span>
    </div>

</div>`;
}

const renderPhotoDetail = (photos) => {
    let photosRender;
    console.log(photos);

    photosRender = '<div>';

    photosRender += '<div class="card-container">';
    photosRender += renderPhoto(photos);
    photosRender += '</div></div>';

    photosRender += '</div>';


    rootDetail.innerHTML = photosRender;
};

const getPhotoDetail = async (id) => {

    let detailUrl = apiUrl;


    detailUrl += artistId;

    try {
        const response = await axios.get(detailUrl);
        renderPhotoDetail(response.data);
    } catch (error) {
        console.log(error);
    }
};

getPhotoDetail();


// send message

function setUserId() {

    var artistId = this.artistId;

    sessionStorage.setItem("artistId", artistId);


    window.location.href = "http://127.0.0.1:5500/front-end/message.html";

}
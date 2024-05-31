const reviews = [{
        id: 1,
        name: "Arun Gautam",
        job: "YouTuber",
        img: "./arun.jpg",
        text: "I am a Youtuber. This website help me to find electrician instantly.",
    },

    {
        id: 2,
        name: "Vijay Sharma ",
        job: "Professor",
        img: "./vijay sharma.jpg",
        text: "hey, my name is  Vijay Sharma. I'm  Math's Professor in ABES Engineering College. I'm sharing my feedback, this website help me to find instant Electrician when i need more."
    },
    {
        id: 3,
        name: "Dr. Pragati",
        job: "Ex-Professor in SDGI",
        img: "./pragati.jpg",
        text: "one day suddenly electric fault occure in my house, i go for finding for electricians, but their is no electrician available, then i found book my electrician.",
    },


];

const img = document.getElementById("person-img");
const author = document.getElementById("author");
const job = document.getElementById("job");
const info = document.getElementById("info");

const prevBtn = document.querySelector(".prev-btn");
const nextBtn = document.querySelector(".next-btn");
const randomBtn = document.querySelector(".random-btn");


let currentItem = 0;


window.addEventListener("DOMContentLoaded", function() {
    const item = reviews[currentItem];
    img.src = item.img;
    author.textContent = item.name;
    job.textContent = item.job;
    info.textContent = item.text;
});

function showPerson(person) {
    const item = reviews[person];
    img.src = item.img;
    author.textContent = item.name;
    job.textContent = item.job;
    info.textContent = item.text;
}

nextBtn.addEventListener("click", function() {
    currentItem++;
    if (currentItem > reviews.length - 1) {
        currentItem = 0;
    }
    showPerson(currentItem);
});

prevBtn.addEventListener("click", function() {
    currentItem--;
    if (currentItem < 0) {
        currentItem = reviews.length - 1;
    }
    showPerson(currentItem);
});

randomBtn.addEventListener("click", function() {
    console.log("hello");

    currentItem = Math.floor(Math.random() * reviews.length);
    showPerson(currentItem);
});
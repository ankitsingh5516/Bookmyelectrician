function submitquery() {
    alert("Your Query have been recoreded, Our team contact soon!..");
}

function book() {
    alert("Our Electrician connect within 10 min");
}

function submitForm() {

    alert("Your Registration is Recorded, Our Team Verifing your Details.!");
}

function ForgetPassward() {
    alert("Your passward send to Your Registered Email id & Mobile No.!");
}

function initMap(): void {
    const myLatlng = { lat: -25.363, lng: 131.044 };

    const map = new google.maps.Map(
        document.getElementById("map") as HTMLElement, {
            zoom: 4,
            center: myLatlng,
        }
    );

    const marker = new google.maps.Marker({
        position: myLatlng,
        map,
        title: "Click to zoom",
    });

    map.addListener("center_changed", () => {
        // 3 seconds after the center of the map has changed, pan back to the
        // marker.
        window.setTimeout(() => {
            map.panTo(marker.getPosition() as google.maps.LatLng);
        }, 3000);
    });

    marker.addListener("click", () => {
        map.setZoom(8);
        map.setCenter(marker.getPosition() as google.maps.LatLng);
    });
}

declare global {
    interface Window {
        initMap: () => void;
    }
}
window.initMap = initMap;
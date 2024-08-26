function deleteCourse(endpoint, courseId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`course${courseId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

function deleteLesson(endpoint, lessonId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`lesson${lessonId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

function deleteVideo(endpoint, videoId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`video${videoId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}
function deleteQuestion(endpoint, questionId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`question${questionId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

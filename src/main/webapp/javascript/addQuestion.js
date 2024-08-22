let questionCount = 0;

function addNewQuestion() {
    questionCount++;
    const newQuestionHTML = `
        <div class="new-question-container mt-4" id="question-${questionCount}">
            <div class="new-question-item">
                <!-- Input để thêm nội dung câu hỏi -->
                <label for="newQuestionContent${questionCount}">Câu hỏi:</label>
                <input type="text" id="newQuestionContent${questionCount}" name="questionContent[${questionCount}]" class="form-control mb-2" placeholder="Nhập nội dung câu hỏi">

        </div>
        </div>
    `;
    document.getElementById('new-questions').insertAdjacentHTML('beforeend', newQuestionHTML);
}

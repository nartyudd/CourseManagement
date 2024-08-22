let answerCount = {}; // Để theo dõi số lượng đáp án cho mỗi câu hỏi

function addNewAnswer(questionId) {
    // Khởi tạo answerCount cho câu hỏi nếu chưa có
    if (!answerCount[questionId]) {
        answerCount[questionId] = 0;
    }
    answerCount[questionId]++;

    let answerIndex = answerCount[questionId];

    // Tạo HTML cho trường nhập liệu đáp án mới
    let newAnswerHtml = `
        <div class="answer-item">
            <label for="isCorrect_${questionId}_${answerIndex}">Đáp án đúng</label>
            <input type="checkbox" id="isCorrect_${questionId}_${answerIndex}" name="isCorrect[${questionId}_${answerIndex}]" />
            <input type="text" id="answerContent_${questionId}_${answerIndex}" name="answerContent[${questionId}_${answerIndex}]" style="width: 50%" />

        </div>
    `;

    // Thêm trường nhập liệu mới vào DOM
    document.getElementById(`new-answers-${questionId}`).insertAdjacentHTML('beforeend', newAnswerHtml);
}

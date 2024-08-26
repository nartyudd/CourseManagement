<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/css/course.css'/>">
<script src="<c:url value='/javascript/addQuestion.js'/>"></script>
<script src="<c:url value='/javascript/addAnswer.js'/>"></script>

<div class="container mt-5">
    <h1 class="text-center text-primary mb-4">QUẢN LÝ BÀI GIẢNG</h1>

    <c:url value="/lessons" var="action" />

    <c:if test="${errMsg != null}">
        <div class="alert alert-danger mb-3">
            ${errMsg}
        </div>
    </c:if>

    <!-- Form for lesson details -->
    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="lesson">
        <form:errors path="*" element="div" cssClass="alert alert-danger mb-3" />

        <div class="form-group mb-4">
            <strong for="name" class="form-label">Tên Bài Giảng:</strong>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên Bài Giảng..." name="name" />
        </div>

        <div class="form-group mb-4">
            <strong for="courseId" class="form-label">Danh mục khóa học:</strong>
            <form:select class="form-control" path="courseId">
                <c:forEach items="${Course}" var="c">
                    <c:choose>
                        <c:when test="${c.id == lesson.courseId.id}">
                            <option value="${c.id}" selected>${c.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${c.id}">${c.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>

        <div class="form-group mb-4">
            <strong for="lessonContent" class="form-label">Nội Dung:</strong>
            <textarea class="form-control" id="lessonContent" name="content" placeholder="Nội dung bài giảng...">${lesson.content}</textarea>
        </div>
        <div class="form-group mb-4">
            <strong for="questions" class="form-label">Bài tập đánh giá:</strong>
            <c:forEach var="question" items="${questions}">
                <c:if test="${question.lessonId.id == lesson.id}">
                    <div class="question-item">
                        <label class="form-label">Câu hỏi:</label>
                        <input type="text" id="questionContent${question.id}" name="questionContent[${question.id}]" value="${question.content}" style="width: 70%">

                        <c:url value="/api/question/${question.id}" var="uD" />
                        <button type="button" onclick="deleteQuestion('${uD}', ${question.id})" class="btn-danger">&times;</button>
                        <c:forEach var="answer" items="${answers}">
                            <c:if test="${answer.questionId.id == question.id}">
                                <div class="answer-item">
                                    <label for="isCorrect${answer.id}">Đáp án đúng</label>
                                    <input type="checkbox" id="isCorrect${answer.id}" name="isCorrect[${answer.id}]" <c:if test="${answer.isCorrect}">checked</c:if>>
                                    <input type="text" id="answerContent${answer.id}" name="answerContent[${answer.id}]" value="${answer.content}" style="width: 50%">
                                    <input type="hidden" name="answerQuestionId[${answer.id}]" value="${question.id}" />
                                </div>
                            </c:if>
                        </c:forEach>
                        <div id="new-answers-${question.id}"></div>
                        <button type="button" class="btn btn-success btn-answer" onclick="addNewAnswer(${question.id})" >Thêm câu trả lời</button>
                    </div>
                </c:if>
            </c:forEach>
            <div id="new-questions"></div>
            <button type="button" class="btn btn-success btn-add" onclick="addNewQuestion()">Thêm câu hỏi</button>
        </div>

        <div class="form-group mb-4">
            <c:set var="videoDisplayed" value="false" />
            <c:forEach items="${video}" var="video">
                <c:if test="${video.lessonId.id == lesson.id}">
                    <c:if test="${!videoDisplayed}">
                        <strong for="lessonContent" class="form-label">Video hướng dẫn:</strong>
                        <c:set var="videoDisplayed" value="true" />
                    </c:if>
                    <div class="video-container">
                        <c:url value="/api/video/${video.id}" var="uD" />
                        <button onclick="deleteVideo('${uD}', ${video.id})" class="btn-danger delete-btn">&times;</button>
                        <video width="320" height="240" controls>
                            <source src="${video.url}" type="video/mp4">
                        </video>
                    </div>

                </c:if>
            </c:forEach>
        </div>

        <div class="form-group mb-4">
            <input type="hidden" name="lessonId" value="${lesson.id}" />
            <div class="form-group">
                <strong for="file">Upload Video:</strong>
                <input type="file" name="file" id="file" class="form-control" />
            </div>
        </div>

        <div class="form-group mb-4">
            <form:hidden path="id" />
            <form:hidden path="courseId" value="${lesson.courseId.id}" />
            <button class="btn btn-success btn-submit" type="submit">
                <c:choose>
                    <c:when test="${lesson.id != null}">
                        Cập nhật Bài Giảng
                    </c:when>
                    <c:otherwise>
                        Thêm Bài Giảng
                    </c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</div>

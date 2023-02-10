<%-- 
    Document   : QuizReview
    Created on : 19-Jul-2022, 01:40:42
    Author     : hieutdhe141410
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="js sizes customelements history pointerevents postmessage postmessage-structuredclones webgl websockets cssanimations csscolumns csscolumns-width csscolumns-span csscolumns-fill csscolumns-gap csscolumns-rule csscolumns-rulecolor csscolumns-rulestyle csscolumns-rulewidth csscolumns-breakbefore csscolumns-breakafter csscolumns-breakinside flexbox picture srcset webworkers" lang="en"><head>
         <jsp:include page="Header.jsp"></jsp:include>
    <div class="container">
        <div class="row pt-17 mt-9">
            <div class="col-md-12 ml-8 border mb-2" style="border-radius: 4px;padding: 24px">
                <div class="row">
                    <c:if test="${isPass}">
                        <div class="alert-success">
                            <h2>Pass</h2>
                        </div>
                    </c:if>
                    <c:if test="${!isPass}">
                        <div class="alert-danger">
                            <h2>Not Pass</h2>
                        </div>
                    </c:if>


                    <div class="col-md-7 fs-3 text-left" style="line-height: 80%;">
                        <h3>Quiz: ${Lesson.getTitle()}</h3>
                        <span style="font-size:14px;">Duration:  ${Quiz.getDuration()} minutes</span>
                        <br>
                        <span style="font-size:14px;">Pass Rate: ${Quiz.getPass_rate()} %</span>
                        <br>
                        <span style="font-size:14px;">Number of Question: ${Quiz.getNumOfQuestion()}</span>
                    </div>
                    <div class="col-md-4 text-right " id="timer-area" style="display: inline;">
                        <span style="font-size:14px;">Total:  ${takTime} </span>
                        <br>
                        <span style="font-size:14px;">Num Correct: ${QuizCalculating.getNumcorrect()} </span>
                        <br>
                        <span style="font-size:14px;">Num Un Answer: ${QuizCalculating.getNumUnAnswer()} </span>
                        <br>
                    </div>
                </div>
                <div class="col-md-12 ml-8 border p-3" style="background-color: #ffffff">
                    <%
                        boolean correctQuestion = false;
                        boolean isSelectedAns = false;
                    %>
                    <c:forEach items="${lstQuestions}" var="q">
                        <div class="question mt-6" id="${q.getId()}" style="
                             color: #658fa9;">
                            <!--Check Question Correct-->
                            <%
                                correctQuestion = false;
                            %>
                            <c:forEach items="${QuizCalculating.getLstCorrectQuestion()}" var="tq">

                                <c:if test="${q.getId() == tq.getId()}">
                                    <div class="alert-success">
                                        <%
                                            correctQuestion = true;
                                        %>
                                    </div>
                                </c:if>                               
                            </c:forEach>
                            <c:if test="<%=correctQuestion%>"> 
                                <div class="alert-success">
                                    <h2>Correct</h2>
                                </div>
                            </c:if>
                            <c:if test="<%=!correctQuestion%>"> 
                                <div class="alert-danger">
                                    <h2>Wrong </h2>
                                </div>
                            </c:if>
                            <h4>${q.getQuestionName()}</h4>                     
                            <h4>${q.getQuestionDetail()}</h4> 
                            <c:forEach items="${q.getAnswer()}" var="ans">


                                <!--Check Selected Answer-->
                                <%
                                    isSelectedAns = false;
                                %>
                                <c:forEach items="${QuizCalculating.getAns_result()}" var="ta">

                                    <c:if test="${ans.getID() == ta.getID()}">
                                        <%
                                            isSelectedAns = true;
                                        %>
                                    </c:if>
                                </c:forEach>
                                <%
                                    String class_name = isSelectedAns == true ? "" : "";
                                %>
                                <c:if test="${ans.isCorrect()}">
                                    <c:if test="<%=isSelectedAns%>">
                                        <div class="mt-1 alert-success">
                                            <input class="ans-form"
                                                   name="${q.getId()}"
                                                   id="${ans.getID()}" 
                                                   type="${q.getNumAnsCorrect()>1?"checkbox":"radio"}"
                                                   value="${ans.getID()}"
                                                   checked="true"
                                                   style="text-decoration-line:underline;"/>
                                            ${ans.getAnswerContent()} 
                                            <label class="label"></label>                            
                                        </div> 
                                    </c:if>
                                    <c:if test="<%=!isSelectedAns%>">
                                        <div class="mt-1 alert-success">
                                            <input class="ans-form"
                                                   name="${q.getId()}"
                                                   id="${ans.getID()}" 
                                                   type="${q.getNumAnsCorrect()>1?"checkbox":"radio"}"
                                                   value="${ans.getID()}"
                                                   ${isSelectedAns = true?"selected":""}
                                                   style="text-decoration-line:underline;"/>
                                            ${ans.getAnswerContent()} 
                                            <label class="label"></label>                            
                                        </div> 
                                    </c:if>
                                </c:if>
                                <c:if test="${!ans.isCorrect()}">
                                    <c:if test="<%=isSelectedAns%>">
                                        <div class="mt-1 alert-danger">
                                            <input class="ans-form"
                                                   name="${q.getId()}"
                                                   id="${ans.getID()}" 
                                                   type="${q.getNumAnsCorrect()>1?"checkbox":"radio"}"
                                                   value="${ans.getID()}"
                                                   checked="true"
                                                   style=""/>
                                            ${ans.getAnswerContent()} 
                                            <label class="label"></label>                            
                                        </div> 
                                    </c:if>
                                    <c:if test="<%=!isSelectedAns%>">
                                        <div class="mt-1">
                                            <input class="ans-form"
                                                   name="${q.getId()}"
                                                   id="${ans.getID()}" 
                                                   type="${q.getNumAnsCorrect()>1?"checkbox":"radio"}"
                                                   value="${ans.getID()}"
                                                   ${isSelectedAns = true?"selected":""}
                                                   style=""/>
                                            ${ans.getAnswerContent()} 
                                            <label class="label"></label>                            
                                        </div> 
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>     
            </div>
        </div>
    </div>
    <!--        JS Vendor, Plugins & Activation Script Files 
    
            Vendors JS -->
    <script src="./assets/js/vendor/modernizr-3.11.7.min.js"></script>
    <script src="./assets/js/vendor/jquery-3.6.0.min.js"></script>
    <script src="./assets/js/vendor/jquery-migrate-3.3.2.min.js"></script>
    <script src="./assets/js/vendor/bootstrap.bundle.min.js"></script>

    <!--        Plugins JS -->
    <script src="./assets/js/plugins/aos.js"></script>
    <script src="./assets/js/plugins/parallax.js"></script>
    <script src="./assets/js/plugins/swiper-bundle.min.js"></script>
    <script src="./assets/js/plugins/perfect-scrollbar.min.js"></script>
    <script src="./assets/js/plugins/jquery.powertip.min.js"></script>
    <script src="./assets/js/plugins/nice-select.min.js"></script>
    <script src="./assets/js/plugins/glightbox.min.js"></script>
    <script src="./assets/js/plugins/jquery.sticky-kit.min.js"></script>
    <script src="./assets/js/plugins/imagesloaded.pkgd.min.js"></script>
    <script src="./assets/js/plugins/masonry.pkgd.min.js"></script>
    <script src="./assets/js/plugins/flatpickr.js"></script>
    <script src="./assets/js/plugins/range-slider.js"></script>
    <script src="./assets/js/plugins/select2.min.js"></script>


    <!--        Activation JS -->
    <script src="./assets/js/main.js"></script>
    <script src="./assets/js/QuizHandle.js"></script>

    <!--</body>-->
    <grammarly-desktop-integration data-grammarly-shadow-root="true"></grammarly-desktop-integration>
</html>

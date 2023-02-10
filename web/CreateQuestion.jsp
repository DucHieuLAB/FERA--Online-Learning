<%-- 
    Document   : CreateQuestion
    Created on : Jun 18, 2022, 12:08:00 AM
    Author     : TRAN DUC HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="DashboardHeader.jsp" %> 
    <body class="main" data-new-gr-c-s-check-loaded="14.1017.0" data-gr-ext-installed="">
        <div id="root">
            <div class="py-5 md:py-0">

                <div
                    class=" top-bar-boxed h-[70px] md:h-[65px] z-[51] border-b border-white/[0.08] mt-12 md:mt-0 -mx-3 sm:-mx-8 md:-mx-0 px-3 md:border-b-0 relative md:fixed md:inset-x-0 md:top-0 sm:px-8 md:px-10 md:pt-10 md:bg-gradient-to-b md:from-slate-100 md:to-transparent dark:md:from-darkmode-700">
                    <div class="h-full flex items-center"><a class="logo -intro-x hidden md:flex xl:w-[180px] block"
                                                             href="/"><img alt="FUKING LOGO" class="logo__image w-6"
                                      src="assets/cssDashboard/logo.9a88cec5.svg"><span class="logo__text text-white text-lg ml-3"> Enigma
                            </span></a>
                        <nav aria-label="breadcrumb" class="-intro-x h-[45px] mr-auto">
                            <ol class="breadcrumb breadcrumb-light">
                                <li class="breadcrumb-item"><a href="#">Application</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                            </ol>
                        </nav>
                        <div class="intro-x relative mr-3 sm:mr-6">
                            <div class="search hidden sm:block"><input type="text"
                                                                       class="search__input form-control border-transparent" placeholder="Search..."><svg
                                                                       xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                                                       fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                                                       stroke-linejoin="round" class="lucide search__icon dark:text-slate-500">
                                <circle cx="11" cy="11" r="8"></circle>
                                <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                                </svg></div><a class="notification sm:hidden" href=""><svg
                                    xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round" class="lucide notification__icon dark:text-slate-500">
                                <circle cx="11" cy="11" r="8"></circle>
                                <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                                </svg></a>

                        </div>
                        <div class="dropdown intro-x mr-4 sm:mr-6" data-tw-placement="bottom-end">
                            <div role="button"
                                 class="dropdown-toggle cursor-pointer notification notification--bullet cursor-pointer"
                                 aria-expanded="false" data-tw-toggle="dropdown"><svg xmlns="http://www.w3.org/2000/svg"
                                                                                 width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                                                                 stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                                                                                 class="lucide notification__icon dark:text-slate-500">
                                <path d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9"></path>
                                <path d="M13.73 21a2 2 0 0 1-3.46 0"></path>
                                </svg></div>
                            <div class="dropdown-menu notification-content pt-2">
                                <div class="dropdown-content notification-content__box">
                                    <div class="notification-content__title">Notifications</div>
                                    <div class="cursor-pointer relative flex items-center">
                                        <div class="w-12 h-12 flex-none image-fit mr-1"><img
                                                alt="Midone Tailwind HTML Admin Template" class="rounded-full"
                                                src="assets/cssDashboard/profile-13.d2befb57.jpg">
                                            <div
                                                class="w-3 h-3 bg-success absolute right-0 bottom-0 rounded-full border-2 border-white dark:border-darkmode-600">
                                            </div>
                                        </div>
                                        <div class="ml-2 overflow-hidden">
                                            <div class="flex items-center"><a href=""
                                                                              class="font-medium truncate mr-5">Catherine Zeta-Jones</a>
                                                <div class="text-xs text-slate-400 ml-auto whitespace-nowrap">05:09 AM</div>
                                            </div>
                                            <div class="w-full truncate text-slate-500 mt-0.5">Contrary to popular belief,
                                                Lorem Ipsum is not simply random text. It has roots in a piece of classical
                                                Latin literature from 45 BC, making it over 20</div>
                                        </div>
                                    </div>
                                    <div class="cursor-pointer relative flex items-center mt-5">
                                        <div class="w-12 h-12 flex-none image-fit mr-1"><img
                                                alt="Midone Tailwind HTML Admin Template" class="rounded-full"
                                                src="assets/cssDashboard/profile-4.eb6bc8ad.jpg">
                                            <div
                                                class="w-3 h-3 bg-success absolute right-0 bottom-0 rounded-full border-2 border-white dark:border-darkmode-600">
                                            </div>
                                        </div>
                                        <div class="ml-2 overflow-hidden">
                                            <div class="flex items-center"><a href="" class="font-medium truncate mr-5">John
                                                    Travolta</a>
                                                <div class="text-xs text-slate-400 ml-auto whitespace-nowrap">05:09 AM</div>
                                            </div>
                                            <div class="w-full truncate text-slate-500 mt-0.5">Contrary to popular belief,
                                                Lorem Ipsum is not simply random text. It has roots in a piece of classical
                                                Latin literature from 45 BC, making it over 20</div>
                                        </div>
                                    </div>
                                    <div class="cursor-pointer relative flex items-center mt-5">
                                        <div class="w-12 h-12 flex-none image-fit mr-1"><img
                                                alt="Midone Tailwind HTML Admin Template" class="rounded-full"
                                                src="assets/cssDashboard/profile-9.30af9082.jpg">
                                            <div
                                                class="w-3 h-3 bg-success absolute right-0 bottom-0 rounded-full border-2 border-white dark:border-darkmode-600">
                                            </div>
                                        </div>
                                        <div class="ml-2 overflow-hidden">
                                            <div class="flex items-center"><a href="" class="font-medium truncate mr-5">Al
                                                    Pacino</a>
                                                <div class="text-xs text-slate-400 ml-auto whitespace-nowrap">03:20 PM</div>
                                            </div>
                                            <div class="w-full truncate text-slate-500 mt-0.5">Contrary to popular belief,
                                                Lorem Ipsum is not simply random text. It has roots in a piece of classical
                                                Latin literature from 45 BC, making it over 20</div>
                                        </div>
                                    </div>
                                    <div class="cursor-pointer relative flex items-center mt-5">
                                        <div class="w-12 h-12 flex-none image-fit mr-1"><img
                                                alt="Midone Tailwind HTML Admin Template" class="rounded-full"
                                                src="assets/cssDashboard/profile-8.35df1feb.jpg">
                                            <div
                                                class="w-3 h-3 bg-success absolute right-0 bottom-0 rounded-full border-2 border-white dark:border-darkmode-600">
                                            </div>
                                        </div>
                                        <div class="ml-2 overflow-hidden">
                                            <div class="flex items-center"><a href=""
                                                                              class="font-medium truncate mr-5">Arnold Schwarzenegger</a>
                                                <div class="text-xs text-slate-400 ml-auto whitespace-nowrap">06:05 AM</div>
                                            </div>
                                            <div class="w-full truncate text-slate-500 mt-0.5">There are many variations of
                                                passages of Lorem Ipsum available, but the majority have suffered alteration
                                                in some form, by injected humour, or randomi</div>
                                        </div>
                                    </div>
                                    <div class="cursor-pointer relative flex items-center mt-5">
                                        <div class="w-12 h-12 flex-none image-fit mr-1"><img
                                                alt="Midone Tailwind HTML Admin Template" class="rounded-full"
                                                src="assets/cssDashboard/profile-12.097d5674.jpg">
                                            <div
                                                class="w-3 h-3 bg-success absolute right-0 bottom-0 rounded-full border-2 border-white dark:border-darkmode-600">
                                            </div>
                                        </div>
                                        <div class="ml-2 overflow-hidden">
                                            <div class="flex items-center"><a href=""
                                                                              class="font-medium truncate mr-5">Christian Bale</a>
                                                <div class="text-xs text-slate-400 ml-auto whitespace-nowrap">04:50 AM</div>
                                            </div>
                                            <div class="w-full truncate text-slate-500 mt-0.5">Contrary to popular belief,
                                                Lorem Ipsum is not simply random text. It has roots in a piece of classical
                                                Latin literature from 45 BC, making it over 20</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="dropdown intro-x w-8 h-8" data-tw-placement="bottom-end">
                            <div role="button"
                                 class="dropdown-toggle cursor-pointer w-8 h-8 rounded-full overflow-hidden shadow-lg image-fit zoom-in"
                                 aria-expanded="false" data-tw-toggle="dropdown"><img
                                    alt="Midone Tailwind HTML Admin Template" src="assets/cssDashboard/profile-4.eb6bc8ad.jpg"></div>

                        </div>
                    </div>
                </div>

                <div class="flex overflow-hidden">
                    <%@include file="DashboardSider.jsp" %>

                    <c:if test="${error == null}">
                        <div class="content">
                            <div class="intro-y flex items-center mt-8">
                                <h2 class="text-lg font-medium mr-auto">Question Create</h2>
                            </div>
                            <a href="QuestionList" class="btn-outline-primary mb-5">Back To List</a>
                            <div class="grid grid-cols-12 gap-6 mt-5">

                                <div class="intro-y col-span-12 lg:col-span-6">                       
                                    <div class="intro-y box p-5">
                                        <c:choose>
                                            <c:when test='${QuestionID == null}'>
                                                <!--Question From-->
                                                <form action = "CreateQuestion" method = "POST">
                                                    <c:if test="${message != nul}">
                                                        <div class="alert alert-success">
                                                            <strong>Success!</strong> ${message}
                                                        </div>
                                                    </c:if>
                                                    <!--Question Name-->
                                                    <div>
                                                        <label for="crud-form-1" class="form-label">Question Name</label>
                                                        <input id="crud-form-1" name="QuestionName" type="text" class="form-control w-full" placeholder="Input Question Name" value="" required> 
                                                    </div> 
                                                    <!--Explanation-->
                                                    <div class="mt-3"><label>Question Explanation</label>
                                                        <div class="mt-2">

                                                            <div class="ck ck-reset ck-editor ck-rounded-corners" role="application" dir="ltr" lang="en" aria-labelledby="ck-editor__label_e3d2f723ba2e009e8e310aea28e50f40d">

                                                                <div class="ck ck-editor__main" role="presentation" >
                                                                    <textarea class="form-control ck-blurred   " lang="en" dir="ltr" rows="4" role="textbox" aria-label="Rich Text Editor, main" contenteditable="true" aria-readonly="true" name="Explanation" required >
                                                                    </textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>                                                                                                             
                                                    <!--dimenston-->
                                                    <div><label for="select-Dimenstion" class="form-label">Dimenstion</label> 
                                                        <select id="select-Dimenstion" class="form-select" aria-label="Default select example2" name="DimenstionID" >                          
                                                            <c:forEach items="${LstDimenstion}" var="d">
                                                                <option value="${d.getDimenstionID()}" >${d.getDimenstionName()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <!--Topic-->
                                                    <div><label for="select-Topic" class="form-label">Topic</label> 
                                                        <select id="select-Topic" class="form-select" aria-label="Default select example2" name="TopicID" >                          
                                                            <c:forEach items="${LstTopic}" var="t">
                                                                <option value="${t.getTopicId()}" >${t.getTopicName()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <!--Subject-->
                                                    <div><label for="select-Subject" class="form-label">Subject</label> 
                                                        <select id="select-Subject" class="form-select" aria-label="Default select example2"  name="SubjectID">                          
                                                            <c:forEach items="${LstSubject}" var="s">
                                                                <option value="${s.getSubjectID()}" >${s.getSubjectName()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <!-- status-->
                                                    <div class="mt-3"><label>Active Status</label>
                                                        <div class="form-switch mt-2"><input type="checkbox" checked="" class="form-check-input" name="Status" ></div>
                                                    </div>
                                                    <!--                                Question Content-->
                                                    <div class="mt-3"><label>Question Content</label>
                                                        <div class="mt-2">

                                                            <div class="ck ck-reset ck-editor ck-rounded-corners" role="application" dir="ltr" lang="en" aria-labelledby="ck-editor__label_e3d2f723ba2e009e8e310aea28e50f40d">

                                                                <div class="ck ck-editor__main" role="presentation" >
                                                                    <textarea class="form-control ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline" lang="en" dir="ltr" role="textbox" aria-label="Rich Text Editor, main" contenteditable="true" aria-readonly="true" name="QuestionDetail" >
                                                                    </textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="text-center mt-5 mb-5">
                                                            <button type="submit" class="btn btn-outline-success w-24 mr-1">Create New question</button> 
                                                        </div>

                                                    </div>
                                                </form>
                                            </c:when >
                                            <c:when test='${QuestionID != null}'>
                                                <!--Question From-->
                                                <form action = "QuestionEdit" method = "POST">
                                                    <c:if test="${message != nul}">
                                                        <div class="alert alert-success">
                                                            <strong>Success!</strong> ${message}
                                                        </div>
                                                    </c:if>
                                                    <!--QuestionID-->
                                                    <div>
                                                        <label for="crud-form-1" class="form-label">Question ID</label>
                                                        <input id="crud-form-1" name="QuestionID" type="text" class="form-control w-full" placeholder="Input Question Name" value="${Question.getId()}" readonly> 
                                                    </div>
                                                    <!--Question Name-->
                                                    <div>
                                                        <label for="crud-form-1" class="form-label">Question Name</label>
                                                        <input id="crud-form-1" name="QuestionName" type="text" class="form-control w-full" placeholder="Input Question Name" value="${Question.getQuestionName()}" required> 
                                                    </div> 
                                                    <!-- Explanation-->
                                                    <div class="mt-3"><label>Question Explanation</label>
                                                        <div class="mt-2">

                                                            <div class="ck ck-reset ck-editor ck-rounded-corners" role="application" dir="ltr" lang="en" aria-labelledby="ck-editor__label_e3d2f723ba2e009e8e310aea28e50f40d">

                                                                <div class="ck ck-editor__main" role="presentation" >
                                                                    <textarea class="form-control ck-blurred   " lang="en" dir="ltr" rows="4" role="textbox" aria-label="Rich Text Editor, main" contenteditable="true" aria-readonly="true" name="Explanation" >${Question.getExplanation()}
                                                                    </textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>                                                                                                             

                                                    <!--dimenston-->
                                                    <div><label for="select-Dimenstion" class="form-label">Dimenstion</label> 
                                                        <select id="select-Dimenstion" class="form-select" aria-label="Default select example2" name="DimenstionID" >                          
                                                            <c:forEach items="${LstDimenstion}" var="d">
                                                                <option value="${d.getDimenstionID()}" ${Dimenstion.getDimenstionName() == d.getDimenstionName()? "selected":""}>${d.getDimenstionName()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <!--Topic-->
                                                    <div><label for="select-Topic" class="form-label">Topic</label> 
                                                        <select id="select-Topic" class="form-select" aria-label="Default select example2" name="TopicID" >                          
                                                            <c:forEach items="${LstTopic}" var="t">
                                                                <option value="${t.getTopicId()}" ${Topic.getTopicId() == t.getTopicId()? "selected":""}>${t.getTopicName()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <!--Subject-->
                                                    <div><label for="select-Subject" class="form-label">Subject</label> 
                                                        <select id="select-Subject" class="form-select" aria-label="Default select example2"  name="SubjectID">                          
                                                            <c:forEach items="${LstSubject}" var="s">
                                                                <option value="${s.getSubjectID()}" ${Subject.getSubjectID() == s.getSubjectID()? "selected":""}>${s.getSubjectName()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <!--Status-->
                                                    <div class="mt-3"><label>Active Status</label>
                                                        <div class="form-switch mt-2"><input type="checkbox" checked="${Question.isStatus()}" class="form-check-input" name="Status" ></div>
                                                    </div>
                                                    <!--Question Content-->
                                                    <div class="mt-3"><label>Question Content</label>
                                                        <div class="mt-2">

                                                            <div class="ck ck-reset ck-editor ck-rounded-corners" role="application" dir="ltr" lang="en" aria-labelledby="ck-editor__label_e3d2f723ba2e009e8e310aea28e50f40d">

                                                                <div class="ck ck-editor__main" role="presentation" >
                                                                    <textarea class="form-control ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline" lang="en" dir="ltr" role="textbox" aria-label="Rich Text Editor, main" contenteditable="true" aria-readonly="true" name="QuestionDetail" >${Question.getQuestionDetail()}
                                                                    </textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="text-center mt-5 mb-5">
                                                            <button type="submit" class="btn btn-outline-success w-24 mr-1">Edit</button> 
                                                        </div>

                                                    </div>
                                                </form>
                                            </c:when>
                                        </c:choose>
                                        <c:if test="${QuestionID != null}">
                                            <!--answer-->
                                            <div class="">
                                                <div class="text-center"><label class="text-lg font-medium mr-auto">Answer</label>    
                                                </div>
                                                <tbody
                                                    <c:forEach items="${Question.getAnswer()}" var="ans">
                                                <br>
                                                <div class="">
                                                    <div>
                                                        <form class="" method="GET" action="AnswerEdit">
                                                            <label>AnswerID = ${ans.getID()}</label>
                                                            <input value="${ans.getID()}" name="EditAnswerID" type="hidden"/>
                                                            <input value="${Question.getId()}" name="EditQuestionID" type="hidden"/>
                                                            <input value="edit" name="service" type="hidden"/>
                                                            <input value="false" name="Detele" id="detele${ans.getID()}" type="hidden"/>
                                                            <div><label for="crud-form-1" class="form-labelmt-2">AnswerContent</label>
                                                                <textarea id="crud-form-1" name="AnswerContent" type="text" class="form-control w-full" placeholder="Input Answer Content " rows="4" required>${ans.getAnswerContent()}</textarea> </div></td>
                                                            <div><label for="crud-form-" class="form-label mt-2">AnswerComent</label><textarea id="crud-form-1" name="AnswerComent" type="text" class="form-control w-full" rows="4" placeholder="Input Comment " required>${ans.getComment()}</textarea></div></td>
                                                            <div class="text-center form-switch" colspan="2">
                                                                <label>IsCorrect</label>
                                                                <input name="ansCorrect" class="form-check-input mt-2" type="checkbox" ${ans.isCorrect()== true ? "checked":""} onclick="return confirm(`Want to change Question Status?  `);">        
                                                            </div>
                                                            <br>
                                                            <div class="text-center" colspan="2">
                                                                <input onclick="return confirm(`Delete ${ans.getID()} - Question: ${Question.getId()}`);" type="submit"  name="Delete" value="Delete"class="btn-outline-danger mr-1">
                                                                <input onclick="return confirm(`Update ${ans.getID()} - Question: ${Question.getId()}`);" type="submit"  name="Update" value="Update" class="btn-outline-success ml-1">
                                                            </div>
                                                        </form>                        
                                                    </div>
                                                </div>
                                            </c:forEach>
                                            <div class="text-center">
                                                <label for="crud-form-1" class="text-lg font-medium mr-auto">Create New Answer</label>
                                            </div>

                                            <form action="AnswerEdit" method="POST">
                                                <input name="AnsQuestionID" value="${Question.getId()}" hidden>
                                                <c:if test="${errorAns != null}">
                                                    <div>${error}</div>
                                                </c:if>
                                                <c:if test="${message != null} ">
                                                    <div>${message}</div>                                        
                                                </c:if>
                                                <!--AnswerContent-->
                                                <div class="mt-3"><label>Answer Content</label>
                                                    <div class="mt-2">
                                                        <div class="ck ck-reset ck-editor ck-rounded-corners" role="application" dir="ltr" lang="en" aria-labelledby="ck-editor__label_e3d2f723ba2e009e8e310aea28e50f40d">
                                                            <div class="ck ck-editor__main" role="presentation" >
                                                                <textarea class="form-control ck-blurred   " lang="en" dir="ltr" rows="4" role="textbox" aria-label="Rich Text Editor, main" contenteditable="true" aria-readonly="true" placeholder="Input Answer Content" name="AnswerContent" >
                                                                </textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> 
                                                <!--Correct-->
                                                <div class="mt-3 text-center"><label>is Correct?</label>
                                                    <div class="form-switch mt-2"><input type="checkbox"  class="form-check-input" name="ansCorrect"></div>
                                                </div>
                                                <!--Comment-->
                                                <div>
                                                    <label for="crud-form-1" class="form-label">Comment</label><input id="crud-form-1" name="CommentAns" type="text" class="form-control w-full" placeholder="Input Comment" > </div>
                                                <div class="text-center">
                                                    <button type="submit" class="btn btn-outline-success w-24 mr-1 mt-5">Create Answer</button>        
                                                </div>

                                            </form>

                                        </div> 
                                    </c:if>

                                </div>   


                            </div>
                        </div>
                    </div>



                </c:if>
                <div>${error}</div>


            </div>
        </div>
    </div>



    <div></div>
    <div></div>
    <div class="ck-body-wrapper">
        <div class="ck ck-reset_all ck-body ck-rounded-corners" dir="ltr">
            <div class="ck ck-balloon-panel ck-balloon-panel_arrow_nw ck-balloon-panel_with-arrow"
                 style="top: 0px; left: 0px;">
                <div class="ck ck-balloon-rotator" z-index="-1">
                    <div class="ck-balloon-rotator__navigation ck-hidden"><button class="ck ck-button ck-off"
                                                                                  type="button" tabindex="-1"
                                                                                  aria-labelledby="ck-editor__aria-label_e5d42d05a3dd39ecf1901a81904a21bd4"><svg
                                class="ck ck-icon ck-button__icon" viewBox="0 0 20 20">
                            <path
                                d="M11.463 5.187a.888.888 0 1 1 1.254 1.255L9.16 10l3.557 3.557a.888.888 0 1 1-1.254 1.255L7.26 10.61a.888.888 0 0 1 .16-1.382l4.043-4.042z">
                            </path>
                            </svg><span class="ck ck-tooltip ck-tooltip_s"><span
                                    class="ck ck-tooltip__text">Previous</span></span><span class="ck ck-button__label"
                                                                                    id="ck-editor__aria-label_e5d42d05a3dd39ecf1901a81904a21bd4">Previous</span></button><span
                            class="ck-balloon-rotator__counter"></span><button class="ck ck-button ck-off" type="button"
                            tabindex="-1" aria-labelledby="ck-editor__aria-label_e17e97ed5f50e735228103a93b174e199"><svg
                                class="ck ck-icon ck-button__icon" viewBox="0 0 20 20">
                            <path
                                d="M8.537 14.813a.888.888 0 1 1-1.254-1.255L10.84 10 7.283 6.442a.888.888 0 1 1 1.254-1.255L12.74 9.39a.888.888 0 0 1-.16 1.382l-4.043 4.042z">
                            </path>
                            </svg><span class="ck ck-tooltip ck-tooltip_s"><span
                                    class="ck ck-tooltip__text">Next</span></span><span class="ck ck-button__label"
                                                                                id="ck-editor__aria-label_e17e97ed5f50e735228103a93b174e199">Next</span></button></div>
                    <div class="ck-balloon-rotator__content"></div>
                </div>
            </div>
            <div class="ck-fake-panel ck-hidden" style="top: 0px; left: 0px; width: 0px; height: 0px;"></div>
        </div>
    </div>
</body>
<grammarly-desktop-integration data-grammarly-shadow-root="true"></grammarly-desktop-integration>    

</html>


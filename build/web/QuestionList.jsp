<%-- 
    Document   : QuestionList
    Created on : Jun 7, 2022, 3:37:31 PM
    Author     : TRAN DUC HIEU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <div class="content container-xl px-4 mt-5 ">
                        <div class="card p-4 mb-4 mt-5 table-wrapper">
                            <div class="d-flex justify-content-between align-items-sm-center flex-column flex-sm-row mb-4">
                                <div class="me-4 mb-3 mb-sm-0">
                                    <h1 class="mb-0 text-bold text-capitalize">Question List</h1>
                                    <div class="small" id="nowTime">
                                    </div>
                                </div>

                            </div>
                            <div class="card-body table-responsive">
                                <c:if test="${error!= null}">
                                    <div class=""><label class="">${error}</label></div>
                                    </c:if>
                                <div class="row">
                                    <a href="CreateQuestion"><button class="btn btn-primary mb-3">Create/Import Question</button></a>
                                    <form action="QuestionList" method="GET">

                                        <div class="text-right mb-4">

                                            <label class="">Filter By : </label>
                                            <select class="search__input " name="filter">
                                                <option value="ID" ${filter=="ID" ? "selected":""}>ID</option>
                                                <option value="QuestionName" ${filter=="QuestionName" ? "selected":""}>QuestionName</option>
                                                <option value="QuestionDetail" ${filter=="QuestionDetail" ? "selected":""}>QuestionDetail</option>
                                                <option value="TopicID" ${filter=="TopicID" ? "selected":""}>Topic</option>
                                                <option value="Explanation" ${filter=="Explanation" ? "selected":""}>Explanation</option>
                                                <option value="Status" ${filter=="Status" ? "selected":""}>Status</option>
                                                <option value="SubjectID" ${filter=="SubjectID" ? "selected":""}>Subject</option>
                                                <option value="DimensionID" ${filter=="DimensionID" ? "selected":""}>Dimension</option>
                                            </select>

                                            <select class="" name="order">
                                                <option ${order== "ASC" ? "selected":""} value="ASC">Ascending</option>
                                                <option ${order== "DESC" ? "selected":""} value="DESC">Descending</option>
                                            </select>

                                            <label class="">Search By : </label>
                                            <select class="search__input " name="search">
                                                <option value="ID" ${searchBY=="ID" ? "selected":""}>ID</option>
                                                <option value="QuestionName" ${searchBY=="QuestionName" ? "selected":""}>QuestionName</option>
                                                <option value="QuestionDetail" ${searchBY=="QuestionDetail" ? "selected":""}>QuestionDetail</option>
                                                <option value="TopicID" ${searchBY=="TopicID" ? "selected":""}>Topic</option>
                                                <option value="Explanation" ${searchBY=="Explanation" ? "selected":""}>Explanation</option>
                                                <option value="Status" ${searchBY=="Status" ? "selected":""}>Status</option>
                                                <option value="SubjectID" ${filter=="SubjectID" ? "selected":""}>Subject</option>
                                                <option value="DimensionID" ${filter=="DimensionID" ? "selected":""}>Dimension</option>
                                            </select>
                                            <input name="SearchKEY" type="text" id="crud-form-1" placeholder="Seach" class="search__input" value="${searchKey!= null? searchKey:""}"><button type="submit" class="btn btn-outline-primary">Search</button>
                                        </div>
                                    </form>   
                                </div>



                                <table class="table table-striped table-hover table-bordered padding-0">
                                    <thead class="table-primary text-center">
                                        <!--                <form action="iteration" method="POST">-->
                                        <tr>
                                            <th>
                    <!--                            <input type="text" name="search" value="${search}" hidden="">
                                                <input type="text" name="sortStatus" value="${requestScope.SORT_STATUS}" hidden="">
                                                <input type="text" name="previousSort" value="${requestScope.SORT_ITERATION}" hidden="">
                                                <input type="text" name="type" value="${requestScope.SUBJECT_CHOOSE.getSubject_code()}" hidden="">-->
                                                <button class="bg-transparent border-0" type="submit" name="sort" value="id"><b>Question ID</b><i class="fa-solid fa-sort"></i></button>
                                            </th>
                                            <th><button class="bg-transparent border-0" type="submit" name="sort" value="QuestionName"><b>Question Name</b><i class="fa-solid fa-sort"></i></button></th>

                                            <th><button class="bg-transparent border-0" type="submit" name="sort" value="Question_Detail"><b>Question Detail</b><i class="fa-solid fa-sort"></i></button></th>
                                            <th><button class="bg-transparent border-0" type="submit" name="sort" value="Status"><b>Status</b><i class="fa-solid fa-sort"></i></button></th>

                                            <th colspan="2">Actions</th>
                                        </tr>
                                        <!--                </form>-->
                                    </thead>
                                    <tbody>
                                        <c:choose>
                                            <c:when test="${requestScope.lstQuestion==null||requestScope.lstQuestion.size()==0}">
                                                <tr><td class="dataTables-empty" colspan="7">No results match your search query</td></tr>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach var="question" items="${requestScope.lstQuestion}">
                                                    <tr>
                                                        <td>${question.getId()}</td>
                                                        <td>${question.getQuestionName()}</td>
                                                        <td>${question.getQuestionDetail()}</td>
                                                        <td class="text-center form-switch">
                                                            <a data-bs-toggle="modal" href="#updateStatus${question.getId()}">
                                                                <input class="form-check-input" type="checkbox" ${question.isStatus()?"checked":""}  onclick="return false;">
                                                            </a>
                                                        </td>
                                                        <td class="text-center">
                                                            <a href="QuestionDetail?id=${question.getId()}">
                                                                <i data-feather="edit">View Detail</i>
                                                            </a>
                                                        </td>

                                                    </tr>

                                                </c:forEach>
                                            </c:otherwise>
                                        </c:choose>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="test-right">

                            <c:forEach var = "i" begin="1" end="${endP}" > 
                                <a href="QuestionList?index=${i}&searchBY=${searchBY}&SearchKEY=${searchKey}&order=${order}&filter=${filter}">${i}</a>
                            </c:forEach>
                        </div>
                    </div>


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


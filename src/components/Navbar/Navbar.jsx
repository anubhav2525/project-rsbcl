import React, { useState } from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  const [isNavVisible, setIsNavVisible] = useState(false);

  const toggleNav = () => {
    setIsNavVisible(!isNavVisible);
  };
  return (
    <nav className="bg-slate-200 md:px-12 md:py-2 p-2 border-gray-200 dark:bg-gray-900 dark:border-gray-700">
      <div className=" flex flex-wrap items-center justify-between ">
        <button
          onClick={toggleNav}
          type="button"
          className="inline-flex items-center p-2 w-8 h-8 justify-center text-gray-900 rounded md:hidden hover:bg-gray-100 hover:text-gray-950 dark:text-gray-100 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
          aria-controls="navbar-multi-level"
          aria-expanded={isNavVisible}
        >
          <span className="sr-only">Open main menu</span>
          <svg
            className="w-6"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 17 14"
          >
            <path
              stroke="currentColor"
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth="2"
              d="M1 1h15M1 7h15M1 13h15"
            />
          </svg>
        </button>

        <div
          className={`w-full  md:block ${isNavVisible ? "block" : "hidden"}`}
          id="navbar-multi-level"
        >
          <ul className="flex flex-col flex-wrap gap-2 font-base tracking-wider p-4 md:p-0 md:px-2 mt-2 border text-xs sm:text-sm border-gray-100 rounded bg-gray-50 md:space-x-1 rtl:space-x-reverse md:flex-row md:justify-evenly md:items-center md:mt-0 md:border-1 md:bg-white dark:bg-gray-800 md:dark:bg-gray-800 dark:border-gray-700 ">
            <li>
              <Link to='/' className="block py-2 px-3 text-gray-900 rounded hover:bg-gray-300 md:py-2 md:px-4 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white ">
                Home
              </Link>
            </li>

            {/* About button  */}
            <li>
              <button
                id="dropdownNavbarLink"
                data-dropdown-toggle="dropdownAbout"
                className="flex items-center justify-between w-full py-2 px-3 text-gray-900 rounded hover:bg-gray-300 md:py-2 md:px-4 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent "
              >
                About{" "}
                <svg
                  className="w-2.5 h-2.5 ms-2.5"
                  aria-hidden="true"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 10 6"
                >
                  <path
                    stroke="currentColor"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    d="m1 1 4 4 4-4"
                  />
                </svg>
              </button>

              <div
                id="dropdownAbout"
                className="z-10 hidden font-normal bg-white divide-y divide-gray-100 rounded shadow w-44 dark:bg-gray-700 dark:divide-gray-600"
              >
                <ul
                  className="py-2 text-sm text-gray-700 dark:text-gray-200"
                  aria-labelledby="dropdownLargeButton"
                >
                  <li aria-labelledby="dropdownNavbarLink">
                    <button
                      id="doubleDropdownButton"
                      data-dropdown-toggle="aboutOption1"
                      data-dropdown-placement="right-start"
                      type="button"
                      className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                    >
                      Excise
                      <svg
                        className="w-2.5 h-2.5 ms-2.5"
                        aria-hidden="true"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 10 6"
                      >
                        <path
                          stroke="currentColor"
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          strokeWidth="2"
                          d="m1 1 4 4 4-4"
                        />
                      </svg>
                    </button>
                    <div
                      id="aboutOption1"
                      className="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700"
                    >
                      <ul
                        className="py-2 text-sm text-gray-700 dark:text-gray-200"
                        aria-labelledby="doubleDropdownButton"
                      >
                        <li>
                          <Link to='about-excise-introduction' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Introduction
                          </Link>
                        </li>
                        <li>
                          <Link to='about-excise-organization' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Organisation setup
                          </Link>
                        </li>
                      </ul>
                    </div>
                  </li>

                  <li aria-labelledby="dropdownNavbarLink">
                    <button
                      id="doubleDropdownButton"
                      data-dropdown-toggle="aboutOption2"
                      data-dropdown-placement="right-start"
                      type="button"
                      className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                    >
                      RSBCL
                      <svg
                        className="w-2.5 h-2.5 ms-2.5"
                        aria-hidden="true"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 10 6"
                      >
                        <path
                          stroke="currentColor"
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          strokeWidth="2"
                          d="m1 1 4 4 4-4"
                        />
                      </svg>
                    </button>
                    <div
                      id="aboutOption2"
                      className="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700"
                    >
                      <ul
                        className="py-2 text-sm text-gray-700 dark:text-gray-200"
                        aria-labelledby="doubleDropdownButton"
                      >
                        <li>
                          <Link to='about-rsbcl-introduction' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Introduction
                          </Link>
                        </li>
                        <li>
                          <Link to='about-rsbcl-memorandom' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Memorandum of Association
                          </Link>
                        </li>
                        <li>
                          <Link to='about-rsbcl-organization' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Organisation setup
                          </Link>
                        </li>
                        <li>
                          <Link to='about-rsbcl-directors' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Board of Directors
                          </Link>
                        </li>
                      </ul>
                    </div>
                  </li>

                  <li aria-labelledby="dropdownNavbarLink">
                    <button
                      id="doubleDropdownButton"
                      data-dropdown-toggle="aboutOption3"
                      data-dropdown-placement="right-start"
                      type="button"
                      className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                    >
                      RSGSM
                      <svg
                        className="w-2.5 h-2.5 ms-2.5"
                        aria-hidden="true"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 10 6"
                      >
                        <path
                          stroke="currentColor"
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          strokeWidth="2"
                          d="m1 1 4 4 4-4"
                        />
                      </svg>
                    </button>
                    <div
                      id="aboutOption3"
                      className="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700"
                    >
                      <ul
                        className="py-2 text-sm text-gray-700 dark:text-gray-200"
                        aria-labelledby="doubleDropdownButton"
                      >
                        <li>
                          <Link to='about-rsgsm' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            About Us
                          </Link>
                        </li>
                      </ul>
                    </div>
                  </li>
                </ul>
              </div>
            </li>

            {/* Directory button  */}
            <li>
              <button
                id="dropdownNavbarLink"
                data-dropdown-toggle="dropdownDirectory"
                className="flex items-center justify-between w-full py-2 px-3 text-gray-900 rounded hover:bg-gray-300 md:py-2 md:px-4 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent "
              >
                Directory{" "}
                <svg
                  className="w-2.5 h-2.5 ms-2.5"
                  aria-hidden="true"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 10 6"
                >
                  <path
                    stroke="currentColor"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    d="m1 1 4 4 4-4"
                  />
                </svg>
              </button>

              <div
                id="dropdownDirectory"
                className="z-10 hidden font-normal bg-white divide-y divide-gray-100 rounded shadow w-44 dark:bg-gray-700 dark:divide-gray-600"
              >
                <ul
                  className="py-2 text-sm text-gray-700 dark:text-gray-200"
                  aria-labelledby="dropdownLargeButton"
                >
                  <li aria-labelledby="dropdownNavbarLink">
                    <button
                      id="doubleDropdownButton"
                      data-dropdown-toggle="directoryOption1"
                      data-dropdown-placement="right-start"
                      type="button"
                      className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                    >
                      Excise
                      <svg
                        className="w-2.5 h-2.5 ms-2.5"
                        aria-hidden="true"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 10 6"
                      >
                        <path
                          stroke="currentColor"
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          strokeWidth="2"
                          d="m1 1 4 4 4-4"
                        />
                      </svg>
                    </button>
                    <div
                      id="directoryOption1"
                      className="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700"
                    >
                      <ul
                        className="py-2 text-sm text-gray-700 dark:text-gray-200"
                        aria-labelledby="doubleDropdownButton"
                      >
                        <li>
                          <Link to='directory-excise-head-office' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Head Office
                          </Link>
                        </li>
                        <li>
                          <Link to='directory-excise-zone-office' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Zone Office
                          </Link>
                        </li>
                        <li>
                          <Link to='directory-excise-deo-office' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            DEO Office
                          </Link>
                        </li>
                        <li>
                          <Link to='directory-excise-circle-office' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Circle Office
                          </Link>
                        </li>
                      </ul>
                    </div>
                  </li>

                  <li aria-labelledby="dropdownNavbarLink">
                    <button
                      id="doubleDropdownButton"
                      data-dropdown-toggle="directoryOption2"
                      data-dropdown-placement="right-start"
                      type="button"
                      className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                    >
                      RSBCL
                      <svg
                        className="w-2.5 h-2.5 ms-2.5"
                        aria-hidden="true"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 10 6"
                      >
                        <path
                          stroke="currentColor"
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          strokeWidth="2"
                          d="m1 1 4 4 4-4"
                        />
                      </svg>
                    </button>
                    <div
                      id="directoryOption2"
                      className="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700"
                    >
                      <ul
                        className="py-2 text-sm text-gray-700 dark:text-gray-200"
                        aria-labelledby="doubleDropdownButton"
                      >
                        <li>
                          <Link to='directory-rsbcl-head-office' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Head Office
                          </Link>
                        </li>
                        <li>
                          <Link to='directory-rsbcl-depots' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            RSBCL Depots
                          </Link>
                        </li>
                      </ul>
                    </div>
                  </li>

                  <li aria-labelledby="dropdownNavbarLink">
                    <button
                      id="doubleDropdownButton"
                      data-dropdown-toggle="directoryOption3"
                      data-dropdown-placement="right-start"
                      type="button"
                      className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                    >
                      RSGSM
                      <svg
                        className="w-2.5 h-2.5 ms-2.5"
                        aria-hidden="true"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 10 6"
                      >
                        <path
                          stroke="currentColor"
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          strokeWidth="2"
                          d="m1 1 4 4 4-4"
                        />
                      </svg>
                    </button>
                    <div
                      id="directoryOption3"
                      className="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700"
                    >
                      <ul
                        className="py-2 text-sm text-gray-700 dark:text-gray-200"
                        aria-labelledby="doubleDropdownButton"
                      >
                        <li>
                          <Link to='directory-rsgsm-head-office' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Head Office
                          </Link>
                        </li>
                        <li>
                          <Link to='directory-rsgsm-sugar-mill' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Sugar Mill
                          </Link>
                        </li>
                        <li>
                          <Link to='directory-rsgsm-reduction-center' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            Reduction Center
                          </Link>
                        </li>
                        <li>
                          <Link to='directory-rsgsm-depots' className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">
                            RSGSM Depots
                          </Link>
                        </li>
                      </ul>
                    </div>
                  </li>
                </ul>
              </div>
            </li>

            {/* login button  */}
            <li>
              <button
                id="dropdownNavbarLink"
                data-dropdown-toggle="dropdownLogin"
                className="flex items-center justify-between w-full py-2 px-3 text-gray-900 rounded hover:bg-gray-300 md:py-2 md:px-4 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent "
              >
                Login{" "}
                <svg
                  className="w-2.5 h-2.5 ms-2.5"
                  aria-hidden="true"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 10 6"
                >
                  <path
                    stroke="currentColor"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    d="m1 1 4 4 4-4"
                  />
                </svg>
              </button>

              <div
                id="dropdownLogin"
                className="z-10 hidden font-normal bg-white divide-y divide-gray-100 rounded shadow w-44 dark:bg-gray-700 dark:divide-gray-600"
              >
                <ul
                  className="py-2 text-sm text-gray-700 dark:text-gray-200"
                  aria-labelledby="dropdownLargeButton"
                >
                  <li aria-labelledby="dropdownNavbarLink">
                    <Link to='excise-login'>
                      <button
                        type="button"
                        className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                      >
                        Excise
                      </button>
                    </Link>
                  </li>
                  <li aria-labelledby="dropdownNavbarLink">
                    <Link to='rsbcl-login'>
                      <button
                        type="button"
                        className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                      >
                        RSBCL
                      </button>
                    </Link>
                  </li>
                  <li aria-labelledby="dropdownNavbarLink">
                    <Link to='rsgsm-login'>
                      <button
                        type="button"
                        className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                      >
                        RSGSM
                      </button>
                    </Link>
                  </li>
                </ul>
              </div>
            </li>

            {/* Requirement button  */}
            <li>
              <button
                id="dropdownNavbarLink"
                data-dropdown-toggle="dropdownRequirement"
                className="flex items-center justify-between w-full py-2 px-3 text-gray-900 rounded hover:bg-gray-300 md:py-2 md:px-4 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent "
              >
                Requirement
                <svg
                  className="w-2.5 h-2.5 ms-2.5"
                  aria-hidden="true"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 10 6"
                >
                  <path
                    stroke="currentColor"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth="2"
                    d="m1 1 4 4 4-4"
                  />
                </svg>
              </button>

              <div
                id="dropdownRequirement"
                className="z-10 hidden font-normal bg-white divide-y divide-gray-100 rounded shadow w-44 dark:bg-gray-700 dark:divide-gray-600"
              >
                <ul
                  className="py-2 text-sm text-gray-700 dark:text-gray-200"
                  aria-labelledby="dropdownLargeButton"
                >
                  <li aria-labelledby="dropdownNavbarLink">
                    <Link to='requirement-excise'>
                      <button
                        type="button"
                        className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                      >
                        Excise
                      </button>
                    </Link>
                  </li>
                  <li aria-labelledby="dropdownNavbarLink">
                    <Link to='requirement-rsbcl'>

                      <button
                        type="button"
                        className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                      >
                        RSBCL
                      </button>
                    </Link>
                  </li>
                  <li aria-labelledby="dropdownNavbarLink">
                    <Link to='requirement-rsgsm'>
                      <button
                        type="button"
                        className="flex items-center justify-between w-full px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
                      >
                        RSGSM
                      </button>
                    </Link>
                  </li>
                </ul>
              </div>
            </li>

            <li>
              <Link to='contact-us' className="block py-2 px-3 text-gray-900 rounded hover:bg-gray-300 md:py-2 md:px-4 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white ">
                Contact Us
              </Link>
            </li>

            <li>
              <Link to='administator-dashboard' className="block py-2 px-3 text-gray-900 rounded hover:bg-gray-300 md:py-2 md:px-4 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white ">
                Administration Dashboard
              </Link>
            </li>
            <li>
              <Link to='mobile-app' className="block py-2 px-3 text-gray-900 rounded hover:bg-gray-300 md:py-2 md:px-4 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white ">
                Mobile App
              </Link>
            </li>
            <li>
              <Link to='analytic-dashboard' className="block py-2 px-3 text-gray-900 rounded hover:bg-gray-300 md:py-2 md:px-4 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white ">
                Analytic Dashboard
              </Link>
            </li>

         
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;

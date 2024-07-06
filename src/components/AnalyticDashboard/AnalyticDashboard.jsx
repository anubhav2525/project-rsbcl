import React from "react";

const AnalyticDashboard = () => {
  return (
    <div className="my-2 py-2 h-[80vh] px-4 md:px-12 bg-slate-200 dark:bg-slate-900">
      {/* Breadcrumb */}
      <div
        className="flex py-1 my-5 text-xs text-gray-700 dark:text-gray-100"
        aria-label="Breadcrumb"
      >
        <ol className="inline-flex items-center rtl:space-x-reverse">
          <li className="inline-flex items-center">
            <div className="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
              Home
            </div>
          </li>
          <li>
            <div className="flex items-center">
              <svg
                className="rtl:rotate-180 block w-3 h-3 mx-1 text-gray-400 "
                aria-hidden="true"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 6 10"
              >
                <path
                  stroke="currentColor"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="2"
                  d="m1 9 4-4-4-4"
                />
              </svg>
              <div className="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">
                Analytic Dashboard
              </div>
            </div>
          </li>
        </ol>
      </div>

      {/* Heading  */}
      <h2 className="mb-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">
        Analytic Dashbaord
      </h2>

      {/* buttons to redirect */}

      <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 md:px-8 py-2 ">
        <div className="grid grid-cols-2 sm:grid-cols-3 gap-4">
          <a
            href="https://va.rajasthan.gov.in/views/LiquorSalesAnalysis/LiquorSalesDashbord?%3Aembed=y&amp;%3AisGuestRedirectFromVizportal=y"
            target="_blank"
            className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 "
          >
            Liquor Sales Analysis
          </a>
          <a
            href="https://va.rajasthan.gov.in/views/LiquorRevenueAnalysis/LiquorRevenueanalysisdashboard?%3Aembed=y&amp;%3Aiid=1&amp;%3AisGuestRedirectFromVizportal=y"
            target="_blank"
            className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 "
          >
            Liquor Revenue Analysis
          </a>
          <a
            href="https://va.rajasthan.gov.in/views/LiquorProductionAnalysis/LiquorProductionAnalysis?%3Aembed=y&amp;%3Aiid=2&amp;%3AisGuestRedirectFromVizportal=y"
            target="_blank"
            className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 "
          >
            Liquor Production Analysis
          </a>
          <a
            href="https://va.rajasthan.gov.in/views/ShopSaleAnalysis/ShopAnalysis?%3Aembed=y&amp;%3Aiid=3&amp;%3AisGuestRedirectFromVizportal=y"
            target="_blank"
            className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 "
          >
            Shop Sale Analysis
          </a>
          <a
            href="https://va.rajasthan.gov.in/views/LiquorSupplyAnalysis/LiquorSupplyAnalysis?%3Aembed=y&amp;%3Aiid=2&amp;%3AisGuestRedirectFromVizportal=y"
            target="_blank"
            className="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 "
          >
            Liquor Supply Analysis
          </a>
        </div>
      </div>
    </div>
  );
};

export default AnalyticDashboard;

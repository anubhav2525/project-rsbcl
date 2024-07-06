import React, { useState, useEffect } from "react";
import {
    financialStatus,
    rsgsmLiquors,
    heritageLiquorData,
    management,
    rsgsmSalesData,
    profitLossData,
    sugarDivision,
    reductionCenters,
    turnOverProfit,
    imes,
    futurePlans
} from "../AboutUs/RsgsmAboutUsData";

const RsgsmAboutUs = () => {
    const [rcFeed, setrcFeed] = useState(0);
    const [rcProduction, setrcProduction] = useState(0);

    const calculateRcFeed = () => {
        let sum = 0;
        reductionCenters.forEach((item, index) => {
            sum += item.feedingDepots;
        });
        setrcFeed(sum);
    };

    const calculateRcProduction = () => {
        let sum = 0;
        reductionCenters.forEach((item, index) => {
            sum += item.productionCapacity;
        });
        setrcProduction(sum);
    };

    useEffect(() => {
        calculateRcFeed();
        calculateRcProduction();
    }, []);

    return (
        <div className="my-2 py-2 px-4 md:px-12 bg-slate-200 dark:bg-slate-900">
            {/* Breadcrumb */}
            <div
                className="flex py-1 my-5 text-xs text-gray-700 dark:text-gray-100"
                aria-label="Breadcrumb"
            >
                <ol className="inline-flex items-center rtl:space-x-reverse">
                    <li className="inline-flex items-center">
                        <div className="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
                            About
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
                                RSGSM
                            </div>
                        </div>
                    </li>
                    <li aria-current="page">
                        <div className="flex items-center">
                            <svg
                                className="rtl:rotate-180  w-3 h-3 mx-1 text-gray-400"
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
                            <span className="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-300">
                                Introduction
                            </span>
                        </div>
                    </li>
                </ol>
            </div>

            {/* Heading  */}
            <h2 className="my-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">
                RSGSM Introduction
            </h2>

            <div className="my-4 flex justify-center">
                <img src="https://excise.rajasthan.gov.in/Images/RSGSM.png" className="h-20 sm:h-24 md:28" alt="" />
            </div>

            <p className="my4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                <strong>Rajasthan State Ganganagar Sugar Mills Limited (RSGSM)</strong>
                is the oldest Public Sector Undertaking (PSU) of
                <strong> Government of Rajasthan,</strong> having legacy of
                pre-independent India. As a PSU, it has experience of about seven
                decades.
            </p>
            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                <strong>Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) </strong>{" "}
                was initially incorporated in the year 1945 as{" "}
                <strong>“The Bikaner Industrial Corporation Ltd., Bikaner”</strong> in
                private sector and privately run from 1945 to 1952. It was leased to the
                State Government of Rajasthan for a period of two years.
            </p>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                The State Government purchased the shares of the managing agents and the
                control of the Company was taken over by the{" "}
                <strong> Government of Rajasthan</strong> w.e.f. 1st July, 1956.
            </p>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                Name of the Company was changed as{" "}
                <strong>‘The Ganganagar Sugar Mills Limited.' </strong> w.e.f. 21.1.1957
                and it was further changed to{" "}
                <strong>‘Rajasthan State Ganganagar Sugar Mills Limited.'</strong>{" "}
                w.e.f. 14th May, 1993.
            </p>

            <div className="flex my-6 flex-row justify-center items-center">
                <img
                    src="https://excise.rajasthan.gov.in/Images/Sugar%20mill.png"
                    alt=""
                    className="sm:h-64"
                />
            </div>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                Sugar Factory and Distillery both were always part of Rajasthan State
                Ganganagar Sugar Mills Limited (RSGSM), since its constitution,
                including its Reduction Centres and Bottling Plants. However it has been
                upgraded and expanded over the time.
            </p>

            <div className="flex my-6 flex-row justify-center items-center">
                <img
                    src="https://excise.rajasthan.gov.in/Images/oldsugarmill2.png"
                    alt=""
                    className="sm:h-64"
                />
            </div>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                At Present The Head Office Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) is in<strong> Centre of Excellence for Revenue Research and Analytics(CoERRA)     Building,</strong> Third Floor, Near Aranya Bhavan, Jhalana, Jaipur institutional area, Rajasthan, but earlier it was close to Khinvsar House and thereafter Chomu House, Jaipur. Before coming to <strong>CoERRA in 2023,</strong> it was in <strong> Nehru Sahkar Bhawan, Jaipur</strong> for about three decades.
            </p>

            <div className="flex my-6 flex-row justify-center items-center">
                <img
                    src="https://excise.rajasthan.gov.in/Images/oldoffice.png"
                    alt=""
                    className="sm:h-64"
                />
            </div>

            <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                Objectives :
            </h2>

            <ul className="my-4 space-y-1 text-gray-500 text-xs sm:text-sm md:text-base text-justify list-disc list-inside dark:text-gray-400 px-3">
                <li>
                    To manufacture sugar from sugarcane and sugar beet and deal in sugar
                    and molasses.
                </li>
                <li>
                    To produce rectified spirit from molasses and grain in its distillery
                    unit.
                </li>
                <li>
                    To carry on business as distillers & manufacturers of Rectified Spirit
                    (RS)/Extra Neutral Alcohol (ENA) and wholesaler of Country Liquor
                    (CL), Rajasthan Made Liquor (RML), Rajasthan Heritage Liqueur (RHL).
                </li>
            </ul>

            <h2 className="my-4  text-lg font-semibold text-gray-900 dark:text-white">
                Management :
            </h2>

            <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-4">
                The State Government owns 99.97 % shares of Rajasthan State Ganganagar
                Sugar Mills Limited (RSGSM). The Company is managed by the Board of
                Directors and the members of the Board are appointed by the Government
                of Rajasthan. <strong>Secretary, Finance (Revenue)</strong> is appointed
                ex-officio Director-in-Charge of the Company. At present, there are 10
                Directors on the Board of the Directors of the Company-
            </p>

            {/* management table  */}
            <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 py-2">
                {/* table here  */}
                <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                        <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                            <thead className="text-xs text-white text-center uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                <tr>
                                    <th scope="col" className="px-2 py-3 border-r border-white">

                                    </th>
                                    <th scope="col" className="px-2 py-3 border-r border-white">
                                        Name
                                    </th>
                                    <th scope="col" className="px-2 py-3 border-r border-white">
                                        Post
                                    </th>
                                    <th scope="col" className="px-2 py-3 border-r border-white">
                                        As
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                {management.map((items, index) => {
                                    return (
                                        <tr
                                            key={index}
                                            className="bg-white text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 dark:border-gray-700"
                                        >
                                            <td className="px-4 py-3 border-x border-slate-300">{items.sNo}</td>
                                            <th
                                                scope="row"
                                                className="px-2 py-3 font-medium text-gray-900 border-x border-slate-300 dark:text-white"
                                            >
                                                {items.name}
                                            </th>
                                            <td className="px-2 py-3 border-x border-slate-300">{items.post}</td>
                                            <td className="px-2 py-3 border-x border-slate-300">{items.as}</td>
                                        </tr>
                                    );
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                Organisational Structure :
            </h2>

            <div className="my-6 flex flex-col justify-center items-center space-y-3">
                <img src="https://excise.rajasthan.gov.in/Images/DIC.png" alt="" className="sm:h-64 md:h-80" />
                <p class="text-slate-600 dark:text-slate-200 tracking-wider sm:text-sm md:text-base text-xs">
                    It has total more than 1000 working staff, having long experience.
                </p>
            </div>

            <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                Works :
            </h2>

            <div className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3 space-y-2">
                {/* sugar division  */}
                <div>Presently, the company has two divisions:-</div>
                <div>
                    <strong> 1. Sugar Division:- </strong> This Divisions mainly looks
                    after crushing of sugarcane and production of sugar. Earlier sugar
                    beet was also grown and used for sugar manufacturing. Apart from the
                    production of sugar from sugarcane, it also looks after production of
                    Jaggery and Brown Sugar(gudia shakkar), in small quantity. This
                    division works from Sugar Factory, Sri ganganagar.
                </div>

                <div>The main works are as follows-</div>

                <ul className="list-disc list-inside px-4">
                    <li>Purchasing of Sugarcane</li>
                    <li>Manufacturing of Sugar from Sugarcane</li>
                    <li>Selling of Sugar & Molasses</li>
                    <li>
                        Production of Rectified Spirit (RS)/Extra Neutral Alcohol (ENA)
                        through Molasses/Grain
                    </li>
                </ul>

                <div className="my-4 px-4">
                    Some Details of Sugar Division are as follows-
                </div>

                {/* sugar cane table */}
                <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4  py-2">
                    {/* sugar cane table here  */}
                    <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                        <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                            <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                                <caption className=" text-center py-3 font-semibold text-gray-900 bg-white dark:text-white dark:bg-gray-800">
                                    <p className=" text-xs sm:text-sm text-gray-500 dark:text-gray-400">
                                        Sugar Cane Crushing, Sugar Production, Rectified Spirit
                                        Production & Electricity Generation
                                    </p>
                                </caption>
                                <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                    <tr>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Year
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Cane Crushed (Lac Qtls.)
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Total no. of days in Crushing Season
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Recovery %
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Sugar Production (Lac Qtls.)
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Electricity Export (units)
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Rectified Spirit Production (Lac BL)
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {sugarDivision.map((items, index) => {
                                        return (
                                            <tr
                                                key={index}
                                                className="bg-white text-xs sm:text-sm text-center tracking-wide border-b dark:bg-gray-600 dark:border-gray-700"
                                            >
                                                <td className="px-2 py-3 border-x border-slate-300">{items.year}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.caneCrushed}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.days}</td>
                                                <td className="px-4 py-3 border-x border-slate-300">{items.recovery}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.sugarProduction}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.electricityExport}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.rectifiedSpirit}</td>
                                            </tr>
                                        );
                                    })}
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div className="grid md:grid-cols-2 gap-4 mt-4">
                        {/* financial table  */}
                        <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                            <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                                <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                                    <caption className=" text-center py-3 font-semibold text-gray-900 bg-white dark:text-white dark:bg-gray-800">
                                        <p className=" text-xs sm:text-sm text-gray-500 dark:text-gray-400">
                                            Financial Status of Sugar Division (Rs. In Crores)
                                        </p>
                                    </caption>
                                    <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white text-center">
                                        <tr className="border-x border-slate-300">
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Year
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Revenue
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Expenditure
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Profit/Loss
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {financialStatus.map((items, index) => {
                                            return (
                                                <tr
                                                    key={index}
                                                    className="bg-white text-xs sm:text-sm tracking-wide border-b text-center dark:bg-gray-600 dark:border-gray-700"
                                                >
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.year}</td>
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.revenue}</td>
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.expenditure}</td>
                                                    <td className="px-4 py-3 border-x border-slate-300">{items.profitLoss}</td>
                                                </tr>
                                            );
                                        })}
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        {/* profit and loss table  */}
                        <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                            <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                                <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                                    <caption className=" text-center py-3 font-semibold text-gray-900 bg-white dark:text-white dark:bg-gray-800">
                                        <p className=" text-xs sm:text-sm text-gray-500 dark:text-gray-400">
                                            Profit and Loss (Rs in Crores)
                                        </p>
                                    </caption>
                                    <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white text-center">
                                        <tr>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Year
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Sugar Factory
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Distillery
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Total
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {profitLossData.map((items, index) => {
                                            return (
                                                <tr
                                                    key={index}
                                                    className="bg-white text-xs sm:text-sm text-center border-b dark:bg-gray-600 dark:border-gray-700"
                                                >
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.year}</td>
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.sugarFactory}</td>
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.distillery}</td>
                                                    <td className="px-4 py-3 border-x border-slate-300">{items.total}</td>
                                                </tr>
                                            );
                                        })}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="my-4">
                    <div>The all three new products-</div>
                    <ul className="list-inside list-disc px-4">
                        <li>Brown Sugar(Gudia shakkar)</li>
                        <li>Jaggery</li>
                        <li>Jaggery Powder</li>
                    </ul>
                    <div>
                        are made in traditional process, without adding any chemical.
                    </div>
                </div>

                <div className="flex justify-center my-6">
                    <img
                        src="https://excise.rajasthan.gov.in/Images/brown%20sugar.png"
                        alt=""
                        className="sm:h-64"
                    />
                </div>

                {/* Liqiuor division */}
                <div className="my-4 text-justify px-4">
                    <strong>2. Liquor Division:- </strong> This Divisions mainly looks
                    after production of Liquor. Apart from this, wine production is also
                    introduced recently. Hand Sanitizers production were also introduced
                    during critical period of Covid-19.
                </div>

                <div className="my-6 flex justify-center">
                    <img
                        src="https://excise.rajasthan.gov.in/Images/hand%20Sanitizer.png"
                        alt=""
                        className="sm:h-64"
                    />
                </div>

                <div className="my-4 py-4">
                    Presently there are 17 Reduction Centres & 85 Depots across Rajasthan.
                    The RSGSM manufactures its liquors mainly in 3 categories-
                </div>

                {/* RSGSM Manufactured Liquors */}
                <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 py-2">
                    <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                        <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                            <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                                <caption className=" text-center py-3 font-semibold text-gray-900 bg-white dark:text-white dark:bg-gray-800">
                                    <p className=" text-xs sm:text-sm text-gray-500 dark:text-gray-400">
                                        RSGSM Manufactured Liquors
                                    </p>
                                </caption>
                                <thead className="text-xs text-white uppercase text-center bg-gray-400 dark:bg-gray-400 dark:text-white">
                                    <tr>
                                        <th scope="col" className="px-2 py-3 border-r border-white ">
                                            S. No.
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Liquor Category
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Sub Category
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Packaging Size (in ML)
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Since (Year)
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {rsgsmLiquors.map((items, index) => {
                                        return (
                                            <tr
                                                key={index}
                                                className="bg-white text-xs sm:text-sm tracking-wide text-center border-b dark:bg-gray-600 dark:border-gray-700"
                                            >
                                                <td className="px-4 py-3 border-x border-slate-300">{items.sNo}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.liquorCategory}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.subCategory}</td>
                                                <td className="px-4 py-3 border-x border-slate-300">{items.packagingSize}</td>
                                                <td className="px-4 py-3 border-x border-slate-300">{items.year}</td>
                                            </tr>
                                        );
                                    })}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div className="my-4 py-2 text-justify">
                    Raj Mahua was also introduced on 19th October, 2021 by RSGSM as new
                    brand, using Mahua of Udaipur Division, as per guidelines of Excise
                    Policy of 2021-22.
                </div>

                <div className="my-4 py-2 text-justify">
                    <div>
                        All the brands were available in the packings of 12, 24 and 48 case
                        of quarts, pints and nips respectively.
                    </div>
                    <div>
                        Starting from Sriganganagar, Rajasthan State Ganganagar Sugar Mills
                        Limited (RSGSM) made its presence in pan Rajasthan, in short span of
                        time.
                    </div>
                </div>

                <div className="my-6 flex justify-center">
                    <img
                        src="https://excise.rajasthan.gov.in/Images/Ganganagar.png"
                        alt=""
                        className="sm:h-80"
                    />
                </div>

                <div className="my-4 px-4">
                    After expansion of upto 20 Reduction Centres (RCs) and 99 Depots, it
                    has reorganized its RC &Depots to manage its economy of scale. At
                    Present, Country Liquor (CL) and Rajasthan Made Liquor (RML) are
                    manufactured through 17 Reduction Centres; Rajasthan Heritage Liquor
                    (RHL) is manufactured in the Jaipur State Distillery (JSD). All are
                    sold through 85 Depots.
                </div>

                <div className="my-6 px-4 font-bold">
                    List of Reduction Centers is as below-
                </div>

                {/* reduction center table  */}
                <div className="my-6 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4  py-2">
                    <div className="relative rounded  overflow-x-auto shadow-md sm:rounded-lg">
                        <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                            <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                                <caption className=" text-center py-3 font-semibold text-gray-900 bg-white dark:text-white dark:bg-gray-800">
                                    <p className=" text-xs sm:text-sm text-gray-500 dark:text-gray-400">
                                        Reduction Centers
                                    </p>
                                </caption>
                                <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white text-center">
                                    <tr className=" border-y  border-white">
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            S. No.
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            District
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Feeding Depots
                                        </th>
                                        <th scope="col" className="px-2 py-3">
                                            Production Capacity Per Day (in Cases)
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {reductionCenters.map((items, index) => {
                                        return (
                                            <tr
                                                key={index}
                                                className="bg-white text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 text-center dark:border-gray-700"
                                            >
                                                <td className="px-2 py-3 border-x border-slate-300">{items.sNo}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.district}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.feedingDepots}</td>
                                                <td className="px-2 py-3 border-x border-slate-300">{items.productionCapacity}</td>
                                            </tr>
                                        );
                                    })}
                                    <tr className="bg-white text-center font-extrabold text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 dark:border-gray-700">
                                        <td className="px-4 py-2"></td>
                                        <td className="px-4 py-2 border-x border-slate-300">Total</td>
                                        <td className="px-4 py-2 border-x border-slate-300">{rcFeed}</td>
                                        <td className="px-4 py-2 border-x border-slate-300">{rcProduction}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div className="space-y-2 my-4">
                    <div>
                        RSGSM is also selling the Country Liquor (CL) and Rajasthan Made
                        Liquor (RML) of Private Supplier through same Depots.
                    </div>
                    <div>
                        Sale of Country Liquor (CL) and Rajasthan Made Liquor (RML) in last
                        few years is as follows-
                    </div>
                </div>

                {/* RSGSM- Sale of Country Liquor (CL) and Rajasthan Made Liquor (RML) table */}
                {/* table  */}
                <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4  py-2">
                    <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                        <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                            <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                                <caption className="text-center py-3 font-semibold text-gray-900 bg-white dark:text-white dark:bg-gray-800">
                                    <p className="text-xs sm:text-sm text-gray-500 dark:text-gray-400">
                                        RSGSM- Sale of Country Liquor (CL) and Rajasthan Made Liquor
                                        (RML) (in Lacs Bulk Litres)
                                    </p>
                                </caption>
                                <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                    <tr className="border-y border-white text-center">
                                        <th className="border-r border-white"></th>
                                        <th
                                            colSpan={3}
                                            scope="col"
                                            className="px-2 py-3 border-x border-white"
                                        >
                                            Own Manufactured
                                        </th>
                                        <th
                                            colSpan={3}
                                            scope="col"
                                            className="px-2 py-3 border-x border-white"
                                        >
                                            Others
                                        </th>
                                    </tr>
                                    <tr className="border-y border-black">
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Year
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Country Liquor (CL)
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Rajasthan Made Liquor (RML)
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Total
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Country Liquor (CL)
                                        </th>
                                        <th scope="col" className="px-2 py-3 border-r border-white">
                                            Rajasthan Made Liquor (RML)
                                        </th>
                                        <th scope="col" className="px-2 py-3">
                                            Total
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {rsgsmSalesData.map((items, index) => {
                                        return (
                                            <tr
                                                key={index}
                                                className="bg-white text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 dark:border-gray-700 text-center"
                                            >
                                                <td className="px-4 py-3 border-x border-slate-300">
                                                    {items.year}
                                                </td>
                                                <td className="px-4 py-3 border-x border-slate-300">
                                                    {items.ownManufactured.countryLiquor}
                                                </td>
                                                <td className="px-4 py-3 border-x border-slate-300">
                                                    {items.ownManufactured.rajasthanMadeLiquor}
                                                </td>
                                                <td className="px-4 py-3 border-x border-slate-300">
                                                    {items.ownManufactured.total}
                                                </td>
                                                <td className="px-4 py-3 border-x border-slate-300">
                                                    {items.others.countryLiquor}
                                                </td>
                                                <td className="px-4 py-3 border-x border-slate-300">
                                                    {items.others.rajasthanMadeLiquor}
                                                </td>
                                                <td className="px-4 py-3 border-x border-slate-300">
                                                    {items.others.total}
                                                </td>
                                            </tr>
                                        );
                                    })}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div className="my-4 px-4">
                    RSGSM is also selling the Country Liquor (CL) and Rajasthan Made
                    Liquor (RML) of Private Supplier through same Depots.
                </div>

                {/* Rajasthan Heritage Liquor */}
                <h2 className="my-8 text-lg font-semibold text-gray-900 dark:text-white">
                    Rajasthan Heritage Liquor :
                </h2>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) is having
                    legacy of pre-independent India and it has experience of more seven
                    decades. It has <strong> Jaipur State</strong> Distillery in Jhotwara,
                    Jaipur, which was established in 1927, under princely estate of Jaipur
                    and <strong>Mandore Distillery</strong> in Mandore, Jodhpur, which was
                    established in 1924, under princely estate of Jodhpur.
                </p>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    Since its formation, Rajasthan State Ganganagar Sugar Mills Limited
                    (RSGSM) had molasses based distillery in SriGanganagar. On account of
                    growing demand, Four More distilleries were acquired, one each at
                    Ajmer (1957), Mandore (1957), Atru (1961) and Pratapgarh (1963). The
                    distillery at Mandore was closed in May 1968 on account of sharabbandi
                    movement and that at Pratapgarh was closed in March, 1973 being a
                    small and uneconomic unit. Subsequently only the{" "}
                    <strong>Jaipur State Distillery</strong> in Jhotwara, Jaipur, remained
                    in work, since other than Rajasthan Heritage Liquor (RHL), all has
                    shifted to Rectified Spirit (RS) or Extra Neutral Alcohol (ENA).
                    However some of the original Pot stills and Vats, including wooden
                    barrels are in the company, as its valuable asset.
                </p>

                <div className="my-6 flex justify-center">
                    <img
                        src="https://excise.rajasthan.gov.in/Images/Distillery.png"
                        alt=""
                        className="sm:h-64"
                    />
                </div>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    RSGSM has set forth to boost the heritage of Rajasthan, India by
                    resuscitating the Heritage Liquor, which was consumed and composed by
                    herbal recipes since ancient times. The ingredients as recipe of
                    liquor have been taken from Regal Legacy, which had been traditionally
                    owned and used by imperial families of Rajasthan.
                </p>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    The Rajasthan Royal Heritage Liquor is a separate and unique segment
                    of alcoholic beverages produced by RSGSM, which is produced in a
                    traditional manner and process, as defined for Heritage Liquor, from
                    soaking to distillation. At present six brands are produced by RSGSM
                    in its own Distillery, established from Estate Times. These Brands are
                    further categorised based on the number of of herbs and spices used as
                    recipes, which are carefully picked and chosen with its quality norms.
                </p>

                <div className="my-4 px-4">
                    <div>The Details of the RHL Brands are as follows:</div>

                    {/* RHL Brands table  */}
                    <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4  py-2">
                        <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                            <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                                <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">

                                    <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white text-center">

                                        <tr className="border-y border-black">
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Category
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Heritage Liquor Brand
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Ingredients (No. of herbs & spices)
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Packaging
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Ex-Distillery Price (in Rupees)
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {heritageLiquorData.map((items, index) => {
                                            return (
                                                <tr
                                                    key={index}
                                                    className="bg-white text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 dark:border-gray-700 text-center"
                                                >
                                                    <td className="px-4 py-3 border-x border-slate-300">
                                                        {items.category}
                                                    </td>
                                                    <td className="px-4 py-3 border-x border-slate-300">
                                                        {items.brand}
                                                    </td>
                                                    <td className="px-4 py-3 border-x border-slate-300">
                                                        {items.ingredients}
                                                    </td>
                                                    <td className="px-4 py-3 border-x border-slate-300">
                                                        {items.packaging}
                                                    </td>
                                                    <td className="px-4 py-3 border-x border-slate-300">
                                                        {items.exDistilleryPrice}
                                                    </td>

                                                </tr>
                                            );
                                        })}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>


                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    All the brands of Rajasthan Heritage Liquor (RHL) are supplied in its unique packaging, for which the theme and design are chosen as per the legacy of Rajasthan, from bottle to label and overall packing. Currently, all brands are having packaging of same quantity, but it may be provided in other sizes as per requirement of franchisee and policy of RSGSM.</p>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    Apart from Rajasthan Royal Heritage Liquor, RSGSM is also planning to introduce Folk Heritage Liquor, for which Sitafal (Custard Apple), Narangi (Orange), Kinnu (Kinnow), Khajoor (Dates), Mahua (Madhooka), Madhu (Honey), Aparaajita (ClitoriaTernatea) are planned under Brand Name of "Raajasi, The Royal".
                </p>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3 font-semibold">Introduced ‘Mahuwa Liquor’, based on mahuwa flowers which was procured from Tribal Zone of Udaipur, Dungarpur through “RAJIVIKA MISSION” and financial amount paid to Tribal women in cluster group through Bank Account.</p>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                    Rajasthan Wines Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) has its own winery, in its Jhotwara Reduction Centre, Jaipur, erstwhile Jaipur State Distillery (established in 1927) premise. Rajwine is the prominent brand of its wine. At present, It has is producing its Guava Wines, from the famous guavas of Sawai Madhopur. Sitafal (Custard Apple), Narangi (Orange), Kinnu (Kinnow), Khajoor (Dates), are some of the other wines, which are in pipeline.
                </p>

                {/* turnover and profit  */}
                <div className="my-4 px-4">
                    <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                        Over All Revenue, Turn Over & Profit :
                    </h2>
                    <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                        RSGSM has played a vital role in safeguarding the excise revenue of the State Government by way of successful implementation of the Excise Policy and has earned reasonable rate of return on the investments made.
                    </p>
                    <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                        Some Details of Turn Over & Profit are as follows-
                    </p>

                    {/* profit and turnover  */}
                    <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 py-2">
                        {/* table here  */}
                        <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                            <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                                <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                                    <thead className="text-xs text-white text-center uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                        <tr>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Year
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Turnover (Rs in Cr.)
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Profit (Rs in Cr.)
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {turnOverProfit.map((items, index) => {
                                            return (
                                                <tr
                                                    key={index}
                                                    className="bg-white text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 dark:border-gray-700"
                                                >
                                                    <td className="px-4 py-3 border-x border-slate-300">{items.year}</td>
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.turnover}</td>
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.profit}</td>
                                                </tr>
                                            );
                                        })}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                {/* csr activities */}
                <div className="my-4 px-4">
                    <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                        CSR Activities :
                    </h2>
                    <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                        RSGSM has shown its commitment towards Corporate Social Responsibility (CSR).
                    </p>
                    <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                        The Details of CSR is as follows-
                    </p>

                    {/* csr activities table  */}
                </div>

                {/* Technological Enhancement in RSGSM */}
                <div className="my-4 px-4">
                    <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                        Technological Enhancement in RSGSM :
                    </h2>

                    <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3"><strong>To Provide seamless and unified IT system to Excise Department, Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) and Rajasthan State Beverages Corporation Limited (RSBCL), an Integrated Excise Management System (IEMS)</strong> is being developed. This will be based on modern architecture and IT tools. It includes its Departments and Co-working Corporations, Concerned Institutions & Organisations, Internal Divisions and Sections, Development Partners and Stakeholders.</p>

                    <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">Some of the details of <strong>Integrated Excise Management System (IEMS)</strong> are as follows-</p>

                    <div className="my-6 flex justify-center">
                        <img src="https://excise.rajasthan.gov.in/Images/IEMS.png" className="sm:h-64" alt="" />
                    </div>

                    {/* imes table  */}
                    <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 py-2">
                        {/* table here  */}
                        <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                            <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                                <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                                    <thead className="text-xs text-white text-center uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                        <tr>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                S. No.
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Works
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {imes.map((items, index) => {
                                            return (
                                                <tr
                                                    key={index}
                                                    className="bg-white text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 dark:border-gray-700"
                                                >
                                                    <td className="px-4 py-3 border-x border-slate-300">{items.sNo}</td>
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.work}</td>
                                                </tr>
                                            );
                                        })}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                {/* future Plans  */}
                <div className="my-6 px-4">
                    <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                        Future Plans :
                    </h2>

                    <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                        Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) has its own vision to grow and diverse its sectors. This involves Information Technology (IT) Integration, Human Resource Advancement, Process Automation and Infrastructure Upgradation to the optimal and ideal stage.
                    </p>

                    <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">
                        Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) has reserved the rights of follwing Brand Names as Trade Mark
                    </p>

                    {/* future plans table  */}
                    <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 py-2">
                        {/* table here  */}
                        <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                            <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                                <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                                    <thead className="text-xs text-white text-center uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                        <tr>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                S. No.
                                            </th>
                                            <th scope="col" className="px-2 py-3 border-r border-white">
                                                Brand Names
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {futurePlans.map((items, index) => {
                                            return (
                                                <tr
                                                    key={index}
                                                    className="bg-white text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 dark:border-gray-700"
                                                >
                                                    <td className="px-4 py-3 border-x border-slate-300">{items.sNo}</td>
                                                    <td className="px-2 py-3 border-x border-slate-300">{items.brandName}</td>
                                                </tr>
                                            );
                                        })}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">Some other names with geographical identity is in due process of rights. In future, RSGSM also intends to enter in Healthcare Products and promote Self-Help Groups (SHGs) in their own way.</p>

                    <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">In Infrastructure Upgradation there is plan of <strong>Integrated Reduction Centre & Depot Centre (IRDC), Integrated Modern and Model Depots (IMMD)</strong> and Improvement of Traditional Distilleries in its heritage premises.</p>

                    <div className="my-6 flex justify-center">
                        <img src="https://excise.rajasthan.gov.in/Images/Reduction%20center.png" alt="" className="sm:h-64" />
                    </div>

                    <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400 px-3">Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) always welcomes ideas to improve its products and process. It also facilitates the development partners and stakeholders in its legal and permissible framework.</p>
                </div>
            </div>
        </div >
    );
};

export default RsgsmAboutUs;

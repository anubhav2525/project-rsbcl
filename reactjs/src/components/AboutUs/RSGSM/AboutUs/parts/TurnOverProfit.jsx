import React, { useState, useEffect } from 'react'
import axios from 'axios';

const TurnOverProfit = () => {
    // api
    const [profitLoss, setProfitLoss] = useState([]);
    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/turnover-profit") // Use the proxied URL
            .then((res) => {
                setProfitLoss(res.data);
                console.log('Response data:', res.data); // Log the response data
            })
            .catch((error) => {
                console.error('Error:', error); // Log any errors
            });
    }, []);
    return (
        <>
            {/* turnover and profit  */}
            <div className="my-4">
                <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                    Over All Revenue, Turn Over & Profit :
                </h2>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                    RSGSM has played a vital role in safeguarding the excise revenue of the State Government by way of successful implementation of the Excise Policy and has earned reasonable rate of return on the investments made.
                </p>

                <p className="my-4 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
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
                                    {profitLoss.map((items, index) => {
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
        </>
    )
}

export default TurnOverProfit

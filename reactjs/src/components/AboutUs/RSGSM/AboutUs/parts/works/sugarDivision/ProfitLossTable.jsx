import React, { useState, useEffect } from 'react'
import axios from 'axios';

const ProfitLossTable = () => {
    // api
    const [profitLoss, setProfitLoss] = useState([]);
    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/profit-loss") // Use the proxied URL
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
                            {profitLoss.map((items, index) => {
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
        </>
    )
}

export default ProfitLossTable

import React, { useState, useEffect } from 'react'
import axios from 'axios';

const FinancialTable = () => {
    // api
    const [financialStatus, setFinancialStatus] = useState([]);
    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/financial-status") // Use the proxied URL
            .then((res) => {
                setFinancialStatus(res.data);
                console.log('Response data:', res.data); // Log the response data
            })
            .catch((error) => {
                console.error('Error:', error); // Log any errors
            });
    }, []);

    return (
        <>
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
        </>
    )
}

export default FinancialTable

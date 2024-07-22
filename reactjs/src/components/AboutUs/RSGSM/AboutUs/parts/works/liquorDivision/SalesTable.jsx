import React, { useState, useEffect } from 'react'
import axios from 'axios';

const SalesTable = () => {
    // api
    const [sales, setSales] = useState([]);
    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/sales-data") // Use the proxied URL
            .then((res) => {
                setSales(res.data);
                console.log('Response data:', res.data); // Log the response data
            })
            .catch((error) => {
                console.error('Error:', error); // Log any errors
            });
    }, []);
    return (
        <div className="my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 py-2">
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
                            {sales.map((items, index) => {
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
    )
}

export default SalesTable

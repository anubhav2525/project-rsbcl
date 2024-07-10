import React, { useState, useEffect } from 'react'
import axios from 'axios';

const ManufacturedLiquors = () => {
    // api
    const [liquors, setLiquors] = useState([]);
    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/liquors") // Use the proxied URL
            .then((res) => {
                setLiquors(res.data);
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
                            {liquors.map((items, index) => {
                                return (
                                    <tr
                                        key={index}
                                        className="bg-white text-xs sm:text-sm tracking-wide text-center border-b dark:bg-gray-600 dark:border-gray-700"
                                    >
                                        <td className="px-4 py-3 border-x border-slate-300">{index + 1}</td>
                                        <td className="px-2 py-3 border-x border-slate-300">{items.liquorCategory}</td>
                                        <td className="px-2 py-3 border-x border-slate-300">{items.subCategory}</td>
                                        <td className="px-4 py-3 border-x border-slate-300">{items.packagingSize[0]},{items.packagingSize[1]}</td>
                                        <td className="px-4 py-3 border-x border-slate-300">{items.year}</td>
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

export default ManufacturedLiquors

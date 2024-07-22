import React, { useState, useEffect } from 'react'
import axios from 'axios';

const RHLBrand = () => {
    // api
    const [rhl, setRhl] = useState([]);
    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/heritage-liquors") // Use the proxied URL
            .then((res) => {
                setRhl(res.data);
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

                        <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white text-center">

                            <tr>
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
                            {rhl.map((items, index) => {
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
    )
}

export default RHLBrand

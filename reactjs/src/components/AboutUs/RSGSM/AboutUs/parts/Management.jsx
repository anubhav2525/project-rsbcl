import React, { useState, useEffect } from 'react'
import axios from 'axios'

const Management = () => {
    const [management, setManagement] = useState([]);
    //api
    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/management") // Use the proxied URL
            .then((res) => {
                setManagement(res.data);
                console.log('Response data:', res.data); // Log the response data
            })
            .catch((error) => {
                console.error('Error:', error); // Log any errors
            });
    }, []);


    return (
        <>
            <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
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
                                            <td className="px-4 py-3 border-x border-slate-300">{index + 1}</td>
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
        </>
    )
}

export default Management

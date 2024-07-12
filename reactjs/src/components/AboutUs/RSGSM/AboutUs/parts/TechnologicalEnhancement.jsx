import React, { useEffect, useState } from 'react'
import axios from 'axios';

const TechnologicalEnhancement = () => {
    // /api/v1/about-rsgsm/imes
    // api
    const [imes, setImes] = useState([]);

    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/imes") // Use the proxied URL
            .then((res) => {
                setImes(res.data);
                console.log('Response data:', res.data); // Log the response data
            })
            .catch((error) => {
                console.error('Error:', error); // Log any errors
            });
    }, []);
    return (
        <div>
            {/* Technological Enhancement in RSGSM */}
            <div className="my-4">
                <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                    Technological Enhancement in RSGSM :
                </h2>

                <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400"><strong>To Provide seamless and unified IT system to Excise Department, Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) and Rajasthan State Beverages Corporation Limited (RSBCL), an Integrated Excise Management System (IEMS)</strong> is being developed. This will be based on modern architecture and IT tools. It includes its Departments and Co-working Corporations, Concerned Institutions & Organisations, Internal Divisions and Sections, Development Partners and Stakeholders.</p>

                <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">Some of the details of <strong>Integrated Excise Management System (IEMS)</strong> are as follows-</p>

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
                                                <td className="px-4 py-3 border-x border-slate-300">{index + 1}</td>
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
        </div>
    )
}

export default TechnologicalEnhancement

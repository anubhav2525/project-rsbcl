import React, { useState, useEffect } from 'react'
import axios from 'axios';

const FuturePlans = () => {
    // api
    const [furutePlans, setFuturePlans] = useState([]);
    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/future-plans") // Use the proxied URL
            .then((res) => {
                setFuturePlans(res.data);
                console.log('Response data:', res.data); // Log the response data
            })
            .catch((error) => {
                console.error('Error:', error); // Log any errors
            });
    }, []);

    return (
        <div className="my-6">
            <h2 className="my-4 text-lg font-semibold text-gray-900 dark:text-white">
                Future Plans :
            </h2>

            <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) has its own vision to grow and diverse its sectors. This involves Information Technology (IT) Integration, Human Resource Advancement, Process Automation and Infrastructure Upgradation to the optimal and ideal stage.
            </p>

            <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">
                Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) has reserved the rights of follwing Brand Names as Trade Mark
            </p>


            {/* future plans table  */}
            <div className="my-4 bg-slate-300 dark:bg-slate-800 p-2 rounded sm:px-4">
                {/* table here  */}
                <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                        <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                            <thead className="text-xs text-white  uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                <tr>
                                    <th scope="col" className="px-2 py-3 border-r border-white">
                                        S. No.
                                    </th>
                                    <th scope="col" className="px-2 py-3 ">
                                        Brand Names
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                {furutePlans.map((items, index) => {
                                    return (
                                        <tr
                                            key={index}
                                            className="bg-white text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 dark:border-gray-700"
                                        >
                                            <td className="px-4 py-3 border-r border-slate-300">{index + 1}</td>
                                            <td className="px-2 py-3">{items.brandName}</td>
                                        </tr>
                                    );
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">Some other names with geographical identity is in due process of rights. In future, RSGSM also intends to enter in Healthcare Products and promote Self-Help Groups (SHGs) in their own way.</p>

            <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">In Infrastructure Upgradation there is plan of <strong>Integrated Reduction Centre & Depot Centre (IRDC), Integrated Modern and Model Depots (IMMD)</strong> and Improvement of Traditional Distilleries in its heritage premises.</p>

            <div className="my-6 flex justify-center">
                <img src="https://excise.rajasthan.gov.in/Images/Reduction%20center.png" alt="" className="sm:h-64" />
            </div>

            <p className="my-2 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400">Rajasthan State Ganganagar Sugar Mills Limited (RSGSM) always welcomes ideas to improve its products and process. It also facilitates the development partners and stakeholders in its legal and permissible framework.</p>
        </div>
    )
}

export default FuturePlans

import React, { useState, useEffect } from 'react'
import axios from 'axios';

const ReductionCenterTable = () => {

    // calculation total
    const [rcFeed, setrcFeed] = useState(0);
    const [rcProduction, setrcProduction] = useState(0);

    const calculateRcFeed = () => {
        let sum = 0;
        reductionCenter.forEach((item, index) => {
            sum += item.feedingDepots;
        });
        setrcFeed(sum);
    };

    const calculateRcProduction = () => {
        let sum = 0;
        reductionCenter.forEach((item, index) => {
            sum += item.productionCapacity;
        });
        setrcProduction(sum);
    };

    // api
    const [reductionCenter, setReductionCenter] = useState([]);
    useEffect(() => {
        axios.get("/api/v1/about-rsgsm/reduction-centers") // Use the proxied URL
            .then((res) => {
                setReductionCenter(res.data);
                console.log('Response data:', res.data); // Log the response data               
            })
            .catch((error) => {
                console.error('Error:', error); // Log any errors
            });
    }, []);

    useEffect(() => {
        calculateRcFeed();
        calculateRcProduction();
    }, [reductionCenter]);

    return (
        <>
            <div className="my-6 font-bold">
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
                                {reductionCenter.map((items, index) => {
                                    return (
                                        <tr
                                            key={index}
                                            className="bg-white text-xs sm:text-sm tracking-wide border-b dark:bg-gray-600 text-center dark:border-gray-700"
                                        >
                                            <td className="px-2 py-3 border-x border-slate-300">{index + 1}</td>
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
        </>
    )
}

export default ReductionCenterTable

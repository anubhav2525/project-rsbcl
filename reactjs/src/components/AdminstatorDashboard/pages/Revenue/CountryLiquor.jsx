import React, { useState, useEffect } from 'react'
import axios from 'axios'

const CountryLiquor = () => {
    const [countryLiquor, setcountryLiquor] = useState([]);

    const year = 2022;
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // Define the asynchronous function for fetching data
    const fetchData = async () => {
        try {
            const response = await fetch('https://api.example.com/data');
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            setcountryLiquor(data);
            setLoading(false);
        } catch (error) {
            setError(error);
            setLoading(false);
        }
    };

    // Use useEffect to call fetchData when the component mounts
    useEffect(() => {
        fetchData();
    }, [year]);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error.message}</div>;
    }


    return (
        <div className='bg-slate-300 dark:bg-slate-800 rounded-md p-4 my-3 md:px-8 '>
            {/* table  */}
            <div className='my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 md:px-8 py-2'>
                {/* table here  */}
                <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                        <table className="w-full  text-left rtl:text-right text-gray-600 dark:text-gray-300">
                            <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                <tr>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300">
                                        S. No.
                                    </th>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300">
                                        Name
                                    </th>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300">
                                        Address
                                    </th>

                                    <th scope="col" className="px-6 py-3 border-r border-slate-300">
                                        Phone No.
                                    </th>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300">
                                        Name
                                    </th>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300">
                                        Address
                                    </th>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300">
                                        Designation
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Phone No.
                                    </th>
                                </tr>
                            </thead>
                            <tbody>


                            </tbody>
                        </table>
                    </div>

                </div>

            </div>
        </div>
    )
}

export default CountryLiquor

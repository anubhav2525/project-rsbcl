import React,{useState,useEffect} from 'react'
import axios from 'axios';

const RsbclDepots = () => {
        // api
        const [depots, setDepots] = useState([]);    
        useEffect(() => {
            axios.get("/api/v1/directory-rsbcl-depots") // Use the proxied URL
                .then((res) => {
                    setDepots(res.data);
                    console.log('Response data:', res.data); // Log the response data
                })
                .catch((error) => {
                    console.error('Error:', error); // Log any errors
                });
        }, []);
    return (
        <div className='my-2 py-2 px-4 md:px-12 bg-slate-200 dark:bg-slate-900' >
            {/* Breadcrumb */}
            <div className="flex py-1 my-5 text-xs text-gray-700 dark:text-gray-100" aria-label="Breadcrumb">
                <ol className="inline-flex items-center rtl:space-x-reverse">
                    <li className="inline-flex items-center">
                        <div className="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
                            Directory
                        </div>
                    </li>
                    <li>
                        <div className="flex items-center">
                            <svg className="rtl:rotate-180 block w-3 h-3 mx-1 text-gray-400 " aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 9 4-4-4-4" />
                            </svg>
                            <div className="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">RSBCL</div>
                        </div>
                    </li>
                    <li aria-current="page">
                        <div className="flex items-center">
                            <svg className="rtl:rotate-180  w-3 h-3 mx-1 text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 9 4-4-4-4" />
                            </svg>
                            <span className="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-300">Depots</span>
                        </div>
                    </li>
                </ol>
            </div>

            {/* Heading  */}
            <h2 className="mb-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">RSBCL Depots</h2>
            <p className="tracking-wider text-center text-gray-500 md:text-lg dark:text-gray-400">Approved Suppliers and Brands</p>

            {/* body area  */}
            <div className='my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4  py-2'>
                {/* Table  */}
                <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                        <table className="w-full text-xs text-left rtl:text-right text-gray-600 dark:text-gray-300">
                            <thead className="text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                <tr>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300 dark:border-slate-400">
                                        S. No.
                                    </th>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300 dark:border-slate-400">
                                        Depot Name
                                    </th>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300 dark:border-slate-400">
                                        Address
                                    </th>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300 dark:border-slate-400">
                                        Email
                                    </th>
                                    <th scope="col" className="px-6 py-3 border-r border-slate-300 dark:border-slate-400">
                                        Mobile
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Phone
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    depots.map((items, index) => {
                                        return (
                                            <tr key={index} className="bg-white tracking-wide border-b dark:bg-gray-600 dark:border-gray-700">
                                                <td className="px-6 py-4 border-r border-slate-300 dark:border-slate-400">
                                                    {index+1}
                                                </td>
                                                <td className="px-6 py-4 font-medium border-r border-slate-300 dark:border-slate-400">
                                                    {items.depotName}
                                                </td>
                                                <td className="px-6 py-4 border-r border-slate-300 dark:border-slate-400">
                                                    {items.address}
                                                </td>
                                                <td className="px-6 py-4 border-r border-slate-300 dark:border-slate-400">
                                                    {items.email}
                                                </td>
                                                <td className="px-6 py-4 border-r border-slate-300 dark:border-slate-400">
                                                    {items.mobileNo}
                                                </td>
                                                <td className="px-6 py-4">
                                                    {items.phoneNo}
                                                </td>
                                            </tr>
                                        )
                                    })
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div >
    )
}

export default RsbclDepots

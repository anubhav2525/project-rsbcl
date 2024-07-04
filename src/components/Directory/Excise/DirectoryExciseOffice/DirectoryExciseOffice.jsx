import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { exciseOffices } from "../data/ExciseOffices"

const DirectoryExciseOffice = () => {
    const { offices } = useParams();
    // console.log(offices)

    const [officeName, setofficeName] = useState("");
    useEffect(() => {
        if (offices == 'head-office') {
            setofficeName("Head Office")
        } else if (offices == 'zone-office') {
            setofficeName("Zone Office")
        } else if (offices == 'deo-office') {
            setofficeName("DEO Office")
        } else if (offices == 'circle-office') {
            setofficeName("Circle Office")
        }

    }, [offices]);

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
                            <div className="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2 dark:text-gray-400 dark:hover:text-white">Excise</div>
                        </div>
                    </li>
                    <li aria-current="page">
                        <div className="flex items-center">
                            <svg className="rtl:rotate-180  w-3 h-3 mx-1 text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 9 4-4-4-4" />
                            </svg>
                            <span className="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-300">{officeName}</span>
                        </div>
                    </li>
                </ol>
            </div>

            {/* Heading  */}
            <h2 className="mb-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">Excise {officeName}</h2>

            <div className='my-5 sm:my-8 '>
                <p className='tracking-wide font-bold mb-2 text-gray-500 text-xs sm:text-sm md:text-lg dark:text-gray-400'>EPBX No.0294 - 2527086, 2526802 Fax No. 0294 - 2526801 & 2527074 </p>
                <p className="tracking-wider text-gray-500 text-xs sm:text-sm md:text-lg dark:text-gray-400">Here are the List of Important Telephone Numbers. Kindly refer to the below list to find the specific Telephone Numbers you require. If you have any other requirement then you can mail us at <a className='font-extrabold text-slate-600 dark:text-slate-200' href="mailto:ctrlroom.ho.excise@rajasthan.gov.in">ctrlroom.ho.excise@rajasthan.gov.in</a></p>
            </div>

            {/* body area  */}
            <div className='my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4  py-2'>
                {/* Table  */}
                <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                        <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
                            <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                                <tr>
                                    <th scope="col" className="px-6 py-3">
                                        S. No.
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Name of Officer/ Minister
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Designation
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Mobile No.
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        STD Code
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Office
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        FAX No.
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Email
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    exciseOffices.map((items, index) => {
                                        return (
                                            <tr key={index} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                                <td className="px-6 py-4">
                                                    {items.SNo}
                                                </td>
                                                <td className="px-6 py-4 font-medium ">
                                                    {items.Name}
                                                </td>
                                                <td className="px-6 py-4">
                                                    {items.Designation}
                                                </td>
                                                <td className="px-6 py-4">
                                                    {items.MobileNo}
                                                </td>
                                                <td className="px-6 py-4">
                                                    {items.STDCode}
                                                </td>
                                                <td className="px-6 py-4">
                                                    {items.Office}
                                                </td>
                                                <td className="px-6 py-4">
                                                    {items.FAXNo}
                                                </td>
                                                <td className="px-6 py-4">
                                                    {items.Email}
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

export default DirectoryExciseOffice

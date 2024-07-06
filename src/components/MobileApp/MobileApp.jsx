import React from 'react'

const MobileApp = () => {
    const data = [{
        id: 1,
        appName: "AppName",
        downloadApp: "App",
        appDescription: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus!",
        appLink: "www.google.com",
        userManual: "",
        videoDemo: "",
        suggestion: ""
    },
    {
        id: 2,
        appName: "",
        downloadApp: "",
        appDescription: "Lorem consectetur adipisicing elit. Natus!",
        appLink: "",
        userManual: "",
        videoDemo: "",
        suggestion: ""
    },
    {
        id: 3,
        appName: "",
        downloadApp: "",
        appDescription: "Lorem ipsum dolor sit amet consectetur adipisic",
        appLink: "",
        userManual: "",
        videoDemo: "",
        suggestion: "22"
    }]

    return (
        <div className='my-2 py-2 px-4 md:px-12 bg-slate-200 dark:bg-slate-900' >

            {/* Breadcrumb */}
            <div className="flex py-1 my-5 text-xs text-gray-700 dark:text-gray-100" aria-label="Breadcrumb">
                <ol className="inline-flex items-center rtl:space-x-reverse">
                    <li className="inline-flex items-center">
                        <div className="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
                            Home
                        </div>
                    </li>

                    <li aria-current="page">
                        <div className="flex items-center">
                            <svg className="rtl:rotate-180  w-3 h-3 mx-1 text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 9 4-4-4-4" />
                            </svg>
                            <span className="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-300">Mobile Application</span>
                        </div>
                    </li>
                </ol>
            </div>

            {/* Heading  */}
            <h2 className="mb-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">Mobile Application</h2>

            {/* table  */}
            <div className='my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 md:px-8 py-2'>
                {/* table here  */}
                <div className="relative rounded overflow-x-auto shadow-md sm:rounded-lg">
                    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
                    <table className="w-full text-sm text-left rtl:text-right text-gray-600 dark:text-gray-300">
                    <thead className="text-xs text-white uppercase bg-gray-400 dark:bg-gray-400 dark:text-white">
                                <tr>
                                    <th scope="col" className="px-6 py-3">
                                        S. No.
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        APP Name
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Download APP
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        APP Description
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Download APP
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        APP User Manual
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        APP Video
                                    </th>
                                    <th scope="col" className="px-6 py-3">
                                        Suggestion
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    data.map((items, index) => {
                                        return (
                                            <tr key={index} className="bg-white tracking-wide border-b dark:bg-gray-600 dark:border-gray-700">
                                                <td className="px-6 py-4">
                                                    {items.id}
                                                </td>
                                                <th scope="row" className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                                    {items.appName}
                                                </th>
                                                <td className="px-6 py-4">
                                                    {items.downloadApp}
                                                </td>
                                                <td className="px-6 py-4">
                                                    {items.appDescription}
                                                </td>
                                                <td className="px-6 py-4">
                                                    <a href={items.appLink} className=''>
                                                        <svg className="w-6 h-6 text-gray-600 dark:text-white dark:hover:text-slate-400 hover:text-gray-800" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" viewBox="0 0 24 24">
                                                            <path fillRule="evenodd" d="M13 11.15V4a1 1 0 1 0-2 0v7.15L8.78 8.374a1 1 0 1 0-1.56 1.25l4 5a1 1 0 0 0 1.56 0l4-5a1 1 0 1 0-1.56-1.25L13 11.15Z" clipRule="evenodd" />
                                                            <path fillRule="evenodd" d="M9.657 15.874 7.358 13H5a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2h-2.358l-2.3 2.874a3 3 0 0 1-4.685 0ZM17 16a1 1 0 1 0 0 2h.01a1 1 0 1 0 0-2H17Z" clipRule="evenodd" />
                                                        </svg>

                                                    </a>
                                                </td>
                                                <td className="px-6 py-4">
                                                    <a href={items.userManual}>
                                                        <svg className="w-6 h-6 text-gray-600 dark:text-white dark:hover:text-slate-400 hover:text-gray-800" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" viewBox="0 0 24 24">
                                                            <path fillRule="evenodd" d="M13 11.15V4a1 1 0 1 0-2 0v7.15L8.78 8.374a1 1 0 1 0-1.56 1.25l4 5a1 1 0 0 0 1.56 0l4-5a1 1 0 1 0-1.56-1.25L13 11.15Z" clipRule="evenodd" />
                                                            <path fillRule="evenodd" d="M9.657 15.874 7.358 13H5a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2h-2.358l-2.3 2.874a3 3 0 0 1-4.685 0ZM17 16a1 1 0 1 0 0 2h.01a1 1 0 1 0 0-2H17Z" clipRule="evenodd" />
                                                        </svg>
                                                    </a>
                                                </td>
                                                <td className="px-6 py-4">
                                                    <a href={items.videoDemo}>
                                                        <svg className="w-6 h-6 text-gray-600 dark:text-white dark:hover:text-slate-400 hover:text-gray-800" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" viewBox="0 0 24 24">
                                                            <path fillRule="evenodd" d="M13 11.15V4a1 1 0 1 0-2 0v7.15L8.78 8.374a1 1 0 1 0-1.56 1.25l4 5a1 1 0 0 0 1.56 0l4-5a1 1 0 1 0-1.56-1.25L13 11.15Z" clipRule="evenodd" />
                                                            <path fillRule="evenodd" d="M9.657 15.874 7.358 13H5a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2h-2.358l-2.3 2.874a3 3 0 0 1-4.685 0ZM17 16a1 1 0 1 0 0 2h.01a1 1 0 1 0 0-2H17Z" clipRule="evenodd" />
                                                        </svg>
                                                    </a>
                                                </td>
                                                <td className="px-6 py-4">
                                                    {items.suggestion}
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

export default MobileApp

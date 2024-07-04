import React from 'react'
import { exciseIntroductionBody } from "./ExciseIntroductionData"
import { exciseIntroductionTable } from "./ExciseIntroductionData"

const ExciseIntroduction = () => {
    return (
        <div className='my-2 py-2 px-4 md:px-12 bg-slate-200 dark:bg-slate-900' >
            {/* Breadcrumb */}
            <div className="flex py-1 my-5 text-xs text-gray-700 dark:text-gray-100" aria-label="Breadcrumb">
                <ol className="inline-flex items-center rtl:space-x-reverse">
                    <li className="inline-flex items-center">
                        <div className="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
                            About
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
                            <span className="ms-1 text-sm font-medium text-gray-500 md:ms-2 dark:text-gray-300">Introduction</span>
                        </div>
                    </li>
                </ol>
            </div>

            {/* Heading  */}
            <h2 className="mb-4 text-2xl font-extrabold leading-none text-gray-600 md:text-3xl dark:text-slate-300 tracking-wide">Excise Introduction</h2>

            {
                exciseIntroductionBody.map((item, index) => {
                    return (
                        <p className="mb-3 text-xs sm:text-sm md:text-base text-justify text-gray-500 tracking-wider dark:text-gray-400" key={index}>
                            {item.content}
                        </p>
                    )
                })
            }

            {/* Lists  */}
            <div className='my-4 bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 md:px-8 py-2 '>
                <h2 className="mb-2 text-sm  sm:text-lg font-bold text-slate-600 dark:text-slate-300">Excise Commissioner & Ex- Officio Prohibition Commissioner and M.D., R.S.B.C.L. Rajasthan</h2>
                <ul className="text-sm sm:text-base space-y-1 text-gray-500 list-disc list-inside sm:tracking-wider dark:text-gray-400">
                    {
                        exciseIntroductionTable.map((items, index) => {
                            return (
                                <li key={index}>
                                    {items.content}
                                </li>
                            )
                        })
                    }
                </ul>
            </div>
        </div >
    )
}

export default ExciseIntroduction

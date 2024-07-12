import React, { useState } from 'react'
import CountryLiquor from './Revenue/CountryLiquor';

const Revenue = () => {
    const [year, setYear] = useState(2024);


    return (
        <>
            <div className='w-full'>



                <div className='bg-slate-300 dark:bg-slate-800 rounded-md p-4'>

                    <div className='mb-6'>

                        <form class="w-full sm:max-w-xl ">
                            <label for="underline_select" class="sr-only">Underline select</label>
                            <select id="underline_select" class="block py-2.5 px-0 w-full text-sm text-gray-700 bg-transparent border-0 border-b-2 border-gray-500 appearance-none dark:text-gray-400 dark:border-gray-700 focus:outline-none focus:ring-0 focus:border-gray-200 peer">
                                <option selected>Choose Year</option>
                                <option value="2024">2024-2025</option>
                                <option value="2023">2023-2024</option>
                                <option value="2022">2022-2023</option>
                            </select>
                        </form>

                    </div>

                    <div className="w-full grid sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-5 gap-4">
                        {/* cl  */}
                        <div className="bg-teal-300 dark:bg-sky-400 shadow rounded-lg p-4">
                            <div className="flex items-center">
                                <div className="flex-shrink-0">
                                    <div className="text-2xl sm:text-3xl leading-none font-bold text-gray-100">2,340 <span className='text-xs'>Cr</span></div>
                                    <h3 className="text-base font-bold mt-2 text-gray-100 tracking-wide">Country Liquor</h3>
                                </div>
                                <div className=" w-0 flex items-center justify-end flex-1 text-green-600 text-sm font-bold">
                                    ( 14.6%
                                    <svg className="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fillRule="evenodd"
                                            d="M5.293 7.707a1 1 0 010-1.414l4-4a1 1 0 011.414 0l4 4a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L6.707 7.707a1 1 0 01-1.414 0z"
                                            clipRule="evenodd"></path>
                                    </svg> )
                                </div>
                            </div>
                        </div>


                        {/* cl  */}
                        <div className="bg-teal-300 dark:bg-sky-400 shadow rounded-lg p-4">
                            <div className="flex items-center">
                                <div className="flex-shrink-0">
                                    <div className="text-2xl sm:text-3xl leading-none font-bold text-gray-100">2,340 <span className='text-xs'>Cr</span></div>
                                    <h3 className="text-base font-bold mt-2 text-gray-100 tracking-wide">RML</h3>
                                </div>
                                <div className=" w-0 flex items-center justify-end flex-1 text-green-600 text-sm font-bold">
                                    ( 14.6%
                                    <svg className="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fillRule="evenodd"
                                            d="M5.293 7.707a1 1 0 010-1.414l4-4a1 1 0 011.414 0l4 4a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L6.707 7.707a1 1 0 01-1.414 0z"
                                            clipRule="evenodd"></path>
                                    </svg> )
                                </div>
                            </div>
                        </div>

                        {/* Beer  */}
                        <div className="bg-teal-300 dark:bg-sky-400 shadow rounded-lg p-4">
                            <div className="flex items-center">
                                <div className="flex-shrink-0">
                                    <div className="text-2xl sm:text-3xl leading-none font-bold text-gray-100">2,340 <span className='text-xs'>Cr</span></div>
                                    <h3 className="text-base font-bold mt-2 text-gray-100 tracking-wide">Beer</h3>
                                </div>
                                <div className=" w-0 flex items-center justify-end flex-1 text-green-600 text-sm font-bold">
                                    ( 14.6%
                                    <svg className="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fillRule="evenodd"
                                            d="M5.293 7.707a1 1 0 010-1.414l4-4a1 1 0 011.414 0l4 4a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L6.707 7.707a1 1 0 01-1.414 0z"
                                            clipRule="evenodd"></path>
                                    </svg> )
                                </div>
                            </div>
                        </div>

                        {/* Indian-Made Foreign Liquor*/}
                        <div className="bg-teal-300 dark:bg-sky-400 shadow rounded-lg p-4">
                            <div className="flex items-center">
                                <div className="flex-shrink-0">
                                    <div className="text-2xl sm:text-3xl leading-none font-bold text-gray-100">2,340 <span className='text-xs'>Cr</span></div>
                                    <h3 className="text-base font-bold mt-2 text-gray-100 tracking-wide">IMFL</h3>
                                </div>
                                <div className=" w-0 flex items-center justify-end flex-1 text-green-600 text-sm font-bold">
                                    ( 14.6%
                                    <svg className="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fillRule="evenodd"
                                            d="M5.293 7.707a1 1 0 010-1.414l4-4a1 1 0 011.414 0l4 4a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L6.707 7.707a1 1 0 01-1.414 0z"
                                            clipRule="evenodd"></path>
                                    </svg> )
                                </div>
                            </div>
                        </div>

                        {/* Total  */}
                        <div className="bg-teal-300 dark:bg-sky-400 shadow rounded-lg p-4">
                            <div className="flex items-center">
                                <div className="flex-shrink-0">
                                    <div className="text-2xl sm:text-3xl leading-none font-bold text-gray-100">2,340 <span className='text-xs'>Cr</span></div>
                                    <h3 className="text-base font-bold mt-2 text-gray-100 tracking-wide">Total</h3>
                                </div>
                                <div className=" w-0 flex items-center justify-end flex-1 text-green-600 text-sm font-bold">
                                    ( 14.6%
                                    <svg className="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fillRule="evenodd"
                                            d="M5.293 7.707a1 1 0 010-1.414l4-4a1 1 0 011.414 0l4 4a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L6.707 7.707a1 1 0 01-1.414 0z"
                                            clipRule="evenodd"></path>
                                    </svg> )
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>

            {/* cl table  */}
            <CountryLiquor year={year} />

        </>
    )
}

export default Revenue

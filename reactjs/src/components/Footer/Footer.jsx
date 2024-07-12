import React, { useState } from 'react'

const Footer = () => {
    const [visitor, setvisitor] = useState(1234567);
    const [date, setDate] = useState("10-Jul-2024");
    return (
        <footer className="bg-slate-200 dark:bg-slate-900 rounded-md">
            <div className='grid grid-cols-1 text-xs sm:text-sm text-gray-500 tracking-wider sm:grid-cols-2 gap-6 md:grid-cols-3 py-4 px-4 sm:px-8'>
                <div>
                    <div>You are visitor No.: <span className='font-bold'>{visitor}</span></div>
                    <div>Last Updated : <span className='font-bold'>{date}</span></div>
                </div>
                <div className='flex flex-col justify-start items-start gap-1'>
                    <div className='font-bold text-gray-400'>Nodal Officer</div>
                    <div className='underline'>Arun Kumar Hasija Additional Commissioner (Administration)</div>
                    <div>0294-2412274</div>
                    <div>aca.udaipur.excise@rajasthan.gov.in</div>
                </div>
                <div className='flex flex-col justify-start items-start gap-4'>
                    <div>
                        <div className='font-bold'>Dy.General Manager (MIS)</div>
                        <div>0141-2744236</div>
                        <div>dgmmis.rsbcl@rajasthan.gov.in</div>
                    </div>
                    <hr class="w-60 h-1 bg-gray-300 border-0 rounded dark:bg-gray-400"></hr>
                    <div>
                        <div className='font-bold'>Sh. Pawan Kumar Garg Company Secretary</div>
                        <div>0141-2741956</div>
                        <div>cosecy.rsgsm@rajasthan.gov.in</div>
                    </div>
                </div>
            </div>

            <div className='py-4 text-center '> <span class="text-base text-gray-500 sm:text-center tracking-wider dark:text-gray-400">&copy; EXCISE Department, Government of Rajasthan, All Rights Reserved </span></div>
        </footer>
    )
}

export default Footer

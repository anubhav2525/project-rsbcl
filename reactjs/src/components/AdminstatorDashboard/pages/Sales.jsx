import React from 'react'

const Sales = () => {
    return (
        <div className='w-full'>
            <div className='my-4 w-full bg-slate-300 dark:bg-slate-800 px-2 rounded sm:px-4 md:px-8 py-2 '>
                <div className='grid grid-cols-3 gap-4 sm:gap-x-8 text-xs'>

                    <button type="button" className=" text-white bg-red-500 hover:bg-red-600 font-medium rounded-lg text-sm px-5 py-2 dark:bg-red-600 dark:hover:bg-red-700">Red</button>
                </div>
            </div>
        </div>
    )
}

export default Sales

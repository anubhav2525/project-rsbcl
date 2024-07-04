import React from 'react'
import { Link } from 'react-router-dom'
const UpperHeader = () => {
    return (
        <div className='grid grid-cols-2 gap-1 sm:grid-cols-4 md:grid-cols-6 w-full py-1 px-2'>
            <Link to='/' className="text-white bg-orange-500 hover:bg-orange-600 font-medium rounded text-xs text-center sm:text-sm px-3 py-1 ">राजस्थान सरकार</Link>
            <Link to='/' className="text-white bg-orange-500 hover:bg-orange-600 font-medium rounded text-xs sm:text-sm px-3 py-1 md:col-span-3">Lorem, ipsum.</Link>
            <Link to='/' className="text-white bg-orange-500 hover:bg-orange-600 font-medium rounded text-xs sm:text-sm px-3 py-1 text-center">Lorem, ipsum dolor.</Link>
            <Link className="text-white bg-orange-500 hover:bg-orange-600 font-medium rounded text-xs sm:text-sm px-3 py-1 text-center">Lorem ipsum dolor sit.</Link>
        </div>
    )
}

export default UpperHeader

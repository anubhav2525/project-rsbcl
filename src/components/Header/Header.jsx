import React from 'react'
import UpperHeader from './UpperHeader.jsx/UpperHeader'
import LowerHeader from './LowerHeader/LowerHeader'

const Header = () => {
    return (
        <div className='px-2 md:px-4'>
            <UpperHeader />
            <LowerHeader />
            <hr className="h-px my-1 dark:bg-white border-0 bg-gray-700" />
        </div>
    )
}

export default Header

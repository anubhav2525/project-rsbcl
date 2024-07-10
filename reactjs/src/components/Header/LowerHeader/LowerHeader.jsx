import React from 'react'
import { Link } from 'react-router-dom'

import GovernmentLogo from "../../assets/image/common/header/government-logo.png"
// import ImesRajasthan from "../../assets/image/common/header/imes-rajasthan.png"
import exciseDept from "../../assets/image/homePage/home/excise-dept.jpg"

const LowerHeader = () => {
  return (
    <div className='px-3 py-2 grid grid-cols-3 sm:grid-cols-4'>
      <div className='grid col-span-2 sm:col-span-3'>
        <div className='flex gap-4 justify-start items-start'>
          <Link to='/'><img src={GovernmentLogo} alt='Government logo' className='sm:h-16 h-12 md:h-20' /></Link>
          <div className='flex flex-col py-2'>
            <div className='sm:text-lg text-xs tracking-wide font-medium text-gray-900 dark:text-white'>Government of Rajasthan</div>
            <div className='sm:text-lg text-sm tracking-wide font-medium text-red-700'>Excise Department</div>
          </div>
        </div>
      </div>
      <div>
        <img src={exciseDept} alt='ImesRasthan' className='sm:h-16 h-12 md:h-20' />
      </div>
    </div >
  )
}

export default LowerHeader

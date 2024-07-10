import React from 'react'
import { Outlet } from 'react-router-dom'
const WithoutNav = () => {
    return (
        <div className='w-screen h-screen bg-slate-200 dark:bg-slate-800'>
            <Outlet />
        </div>
    )
}

export default WithoutNav

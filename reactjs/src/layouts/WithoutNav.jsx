import React from 'react'
import { Outlet } from 'react-router-dom'
import Header from '../components/Header/Header'
const WithoutNav = () => {
    return (
        <div className='w-screen h-screen bg-slate-200 dark:bg-slate-800'>
            <header className='bg-slate-200 dark:bg-slate-900'>
                <Header />
            </header>
            <main>
                <Outlet />
            </main>
        </div>
    )
}

export default WithoutNav

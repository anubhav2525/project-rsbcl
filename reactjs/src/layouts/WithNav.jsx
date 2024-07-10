import React from 'react'
import { Outlet } from 'react-router-dom'
import Header from "../components/Header/Header"
import Footer from "../components/Footer/Footer"
import Navbar from "../components/Navbar/Navbar"

const WithNav = () => {
    return (
        <div className='bg-slate-100 select-none dark:bg-slate-800'>
            <header className='bg-slate-200 dark:bg-slate-900'>
                <Header />
                <Navbar />
            </header>
            <main>
                <Outlet />
            </main>

            <Footer />

        </div>
    )
}

export default WithNav

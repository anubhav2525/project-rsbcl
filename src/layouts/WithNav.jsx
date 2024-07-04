import React from 'react'
import { Outlet } from 'react-router-dom'
import Header from "../components/Header/Header"
import Footer from "../components/Footer/Footer"
import Navbar from "../components/Navbar/Navbar"
const WithNav = () => {
    return (
        <div className='w-screen h-screen bg-slate-100 dark:bg-slate-800'>
            <header className='bg-slate-200 dark:bg-slate-900'>
                <Header />
                <Navbar />
            </header>
            <main>
                <Outlet />
            </main>
            <footer>
                <Footer />
            </footer>
        </div>
    )
}

export default WithNav

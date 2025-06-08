import React from "react";
import MainNavbar from "@/components/features/main/navbar";
import MainHero from "@/components/features/main/hero";
import MainFeatures from "@/components/features/main/features";
import MainTopCategories from "@/components/features/main/top-categories";
import MainAdvantages from "@/components/features/main/advantages";
import MainBlogs from "@/components/features/main/blogs";
import MainNewsLetter from "@/components/features/main/news-letter";
import MainFooter from "@/components/features/main/footer";

const Page = () => {
  return (
    <main className="min-h-screen">
      <MainNavbar />

      <MainHero />

      <MainFeatures />

      <MainTopCategories />

      <MainAdvantages />

      <MainBlogs />

      <MainNewsLetter />

      <MainFooter />
    </main>
  );
};

export default Page;

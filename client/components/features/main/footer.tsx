import React from "react";
import {
  FacebookIcon,
  Instagram,
  LinkedinIcon,
  LucideTwitter,
} from "lucide-react";
import { Button } from "@/components/ui/button";
import Link from "next/link";

const MainFooter = () => {
  const socials = [
    { title: "Facebook", icon: FacebookIcon, link: "#" },
    { title: "Twitter", icon: LucideTwitter, link: "#" },
    { title: "Instagram", icon: Instagram, link: "#" },
    { title: "LinkedIn", icon: LinkedinIcon, link: "#" },
  ];

  const quickLinks = [
    { title: "Home", link: "/" },
    { title: "About Us", link: "#" },
    { title: "Courses", link: "#" },
    { title: "Contact", link: "#" },
    { title: "Blog", link: "#" },
  ];
  const learnings = [
    { title: "Business", link: "#" },
    { title: "Development", link: "#" },
    { title: "Marketing", link: "#" },
    { title: "Design", link: "#" },
    { title: "Photography", link: "#" },
  ];
  return (
    <footer className="pt-20 pb-10 border-t">
      <div className="container px-4 mx-auto">
        <div className="grid grid-cols-1 gap-12 mb-16 md:grid-cols-2 lg:grid-cols-5">
          <div className="lg:col-span-2">
            <h3 className="mb-6 text-2xl font-bold">Study Box</h3>
            <p className="mb-6 text-muted-foreground max-w-md">
              A modern e-learning platform with expert instructors and
              high-quality courses to help you achieve your goals.
            </p>
            <div className="flex space-x-4">
              {socials.map((social, i) => (
                <Link href={social.link} key={i} passHref={true}>
                  <Button
                    key={i}
                    variant="outline"
                    size="icon"
                    className="rounded-full w-10 h-10 border-gray-200 cursor-pointer"
                  >
                    <social.icon className="w-5 h-5" />
                    <span className="sr-only">{social.title}</span>
                  </Button>
                </Link>
              ))}
            </div>
          </div>
          <div>
            <h4 className="mb-6 text-lg font-semibold">Quick Links</h4>
            <ul className="space-y-4">
              {quickLinks.map((quickLink, i) => (
                <li key={i}>
                  <a
                    href={quickLink.link}
                    className="text-muted-foreground hover:text-primary transition-colors"
                  >
                    {quickLink.title}
                  </a>
                </li>
              ))}
            </ul>
          </div>
          <div>
            <h4 className="mb-6 text-lg font-semibold">Learning</h4>
            <ul className="space-y-4">
              {learnings.map((learning, i) => (
                <li key={i}>
                  <a
                    href={learning.link}
                    className="text-muted-foreground hover:text-primary transition-colors"
                  >
                    {learning.title}
                  </a>
                </li>
              ))}
            </ul>
          </div>
          <div>
            <h4 className="mb-6 text-lg font-semibold">Contact Info</h4>
            <ul className="space-y-4 text-muted-foreground">
              <li className="flex items-start gap-3">
                <div className="flex-shrink-0 mt-1">📍</div>
                <div>123 Education St, Learning City, 10001</div>
              </li>
              <li className="flex items-start gap-3">
                <div className="flex-shrink-0 mt-1">📧</div>
                <div>info@wahyedu.com</div>
              </li>
              <li className="flex items-start gap-3">
                <div className="flex-shrink-0 mt-1">📞</div>
                <div>+1 (123) 456-7890</div>
              </li>
            </ul>
          </div>
        </div>
        <div className="pt-8 mt-8 text-center border-t">
          <p className="text-muted-foreground">
            © {new Date().getFullYear()} Study Box. All rights reserved.
          </p>
          <div className="flex justify-center mt-4 space-x-6">
            <a
              href="#"
              className="text-sm text-muted-foreground hover:text-primary"
            >
              Privacy Policy
            </a>
            <a
              href="#"
              className="text-sm text-muted-foreground hover:text-primary"
            >
              Terms of Service
            </a>
            <a
              href="#"
              className="text-sm text-muted-foreground hover:text-primary"
            >
              Cookie Policy
            </a>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default MainFooter;

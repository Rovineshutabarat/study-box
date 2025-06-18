import React from "react";
import {
  FacebookIcon,
  Instagram,
  LinkedinIcon,
  TwitterIcon,
} from "lucide-react";
import { Button } from "@/components/ui/button";

const MainFooter = () => {
  return (
    <footer className="pt-20 pb-10 border-t">
      <div className="container px-4 mx-auto">
        <div className="grid grid-cols-1 gap-12 mb-16 md:grid-cols-2 lg:grid-cols-5">
          <div className="lg:col-span-2">
            <h3 className="mb-6 text-2xl font-bold">Wahyedu</h3>
            <p className="mb-6 text-muted-foreground max-w-md">
              A modern e-learning platform with expert instructors and
              high-quality courses to help you achieve your goals.
            </p>
            <div className="flex space-x-4">
              {[
                { icon: FacebookIcon, name: "Facebook" },
                { icon: TwitterIcon, name: "Twitter" },
                { icon: Instagram, name: "Instagram" },
                { icon: LinkedinIcon, name: "LinkedIn" },
              ].map((social, i) => (
                <Button
                  key={i}
                  variant="outline"
                  size="icon"
                  className="rounded-full w-10 h-10 border-gray-200"
                >
                  <social.icon className="w-5 h-5" />
                  <span className="sr-only">{social.name}</span>
                </Button>
              ))}
            </div>
          </div>
          <div>
            <h4 className="mb-6 text-lg font-semibold">Quick Links</h4>
            <ul className="space-y-4">
              {["Home", "About Us", "Courses", "Contact", "Blog"].map(
                (link, i) => (
                  <li key={i}>
                    <a
                      href="#"
                      className="text-muted-foreground hover:text-primary transition-colors"
                    >
                      {link}
                    </a>
                  </li>
                ),
              )}
            </ul>
          </div>
          <div>
            <h4 className="mb-6 text-lg font-semibold">Learning</h4>
            <ul className="space-y-4">
              {[
                "Business",
                "Development",
                "Marketing",
                "Design",
                "Photography",
              ].map((link, i) => (
                <li key={i}>
                  <a
                    href="#"
                    className="text-muted-foreground hover:text-primary transition-colors"
                  >
                    {link}
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
            © {new Date().getFullYear()} Wahyedu. All rights reserved.
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
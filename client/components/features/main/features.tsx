import React from "react";
import {
  Bell,
  BookOpen,
  Briefcase,
  Globe,
  Laptop,
  Newspaper,
} from "lucide-react";
import { Card, CardContent } from "@/components/ui/card";

const MainFeatures = () => {
  const cardContents = [
    {
      title: "Courses & Workshops",
      description:
        "Ac tincidunt sapien vehicula erat auctor pellentesque rhoncus. Et magna sit morbi lobortis.",
      icon: <BookOpen />,
    },
    {
      title: "Industry Leading Certifications",
      description:
        "Ac tincidunt sapien vehicula erat auctor pellentesque rhoncus. Et magna sit morbi lobortis.",
      icon: <Newspaper />,
    },
    {
      title: "Track your Learning",
      description:
        "Ac tincidunt sapien vehicula erat auctor pellentesque rhoncus. Et magna sit morbi lobortis.",
      icon: <Laptop />,
    },
    {
      title: "Community Professionals",
      description:
        "Ac tincidunt sapien vehicula erat auctor pellentesque rhoncus. Et magna sit morbi lobortis.",
      icon: <Globe />,
    },
    {
      title: "Get Job Ready Skills",
      description:
        "Ac tincidunt sapien vehicula erat auctor pellentesque rhoncus. Et magna sit morbi lobortis.",
      icon: <Briefcase />,
    },
    {
      title: "Subscription Based",
      description:
        "Ac tincidunt sapien vehicula erat auctor pellentesque rhoncus. Et magna sit morbi lobortis.",
      icon: <Bell />,
    },
  ];

  return (
    <section className="py-20">
      <div className="container px-4 mx-auto">
        <div className="max-w-3xl mx-auto mb-16 text-center">
          <h2 className="mb-4 text-2xl font-bold md:text-3xl">
            Get <span className="text-blue-500">Career Ready</span> Skills
          </h2>
          <p className="text-muted-foreground">
            What are the benefits you'll get learning with us?
          </p>
        </div>
        <div className="grid grid-cols-1 gap-8 md:grid-cols-2 lg:grid-cols-3">
          {cardContents.map((card, index) => {
            return (
              <Card className="border-transparent hover:shadow-sm hover:shadow-primary/20 dark:hover:bg-accent/10 shadow-sm transition-all duration-300 rounded-lg overflow-hidden">
                <CardContent className="p-8 text-center">
                  <div className="flex items-center justify-center w-12 h-12 mx-auto mb-6 rounded-lg bg-blue-500 text-white">
                    {card.icon}
                  </div>
                  <h3 className="mb-3 text-xl font-semibold">{card.title}</h3>
                  <p className="text-muted-foreground">{card.description}</p>
                </CardContent>
              </Card>
            );
          })}
        </div>
      </div>
    </section>
  );
};

export default MainFeatures;

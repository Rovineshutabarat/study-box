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
  const topFeatures = [
    {
      title: "Courses",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      icon: <BookOpen />,
    },
    {
      title: "Workshops",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      icon: <Newspaper />,
    },
    {
      title: "Track your Learning",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      icon: <Laptop />,
    },
    {
      title: "Community Professionals",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      icon: <Globe />,
    },
    {
      title: "Get Job Ready Skills",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      icon: <Briefcase />,
    },
    {
      title: "Subscription Based",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
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
          {topFeatures.map((feature) => {
            return (
              <Card
                key={feature.title}
                className="border-transparent hover:shadow-sm hover:shadow-primary/20 dark:hover:bg-accent/10 shadow-sm transition-all duration-300 rounded-lg overflow-hidden"
              >
                <CardContent className="p-8 text-center">
                  <div className="flex items-center justify-center w-12 h-12 mx-auto mb-6 rounded-lg bg-blue-500 text-white">
                    {feature.icon}
                  </div>
                  <h3 className="mb-3 text-xl font-semibold">
                    {feature.title}
                  </h3>
                  <p className="text-muted-foreground">{feature.description}</p>
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
